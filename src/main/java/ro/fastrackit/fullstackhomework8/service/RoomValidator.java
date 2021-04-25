package ro.fastrackit.fullstackhomework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.fastrackit.fullstackhomework8.exception.ValidationException;
import ro.fastrackit.fullstackhomework8.model.entity.Room;
import ro.fastrackit.fullstackhomework8.repository.RoomRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoomValidator {
    private final RoomRepository roomRepository;

    public void validateNewThrow(Room newRoom) {
        validate(newRoom, true)
                .ifPresent(ex -> {
                    throw ex;
                });
    }

    public void validateReplaceThrow(long roomId, Room newRoom) {
        exists(roomId)
                .or(() -> validate(newRoom, false))
                .ifPresent(ex -> {
                    throw ex;
                });
    }

    private Optional<ValidationException> validate(Room room, boolean newEntity) {
        if (room.getRoomNUmber() == null) {
            return Optional.of(new ValidationException("Number cannot be null"));
        } else if (newEntity && roomRepository.findByNumber(room.getRoomNUmber())) {
            return Optional.of(new ValidationException("Number cannot be duplicate"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidationException> exists(long roomId) {
        return roomRepository.existsById(roomId)
                ? Optional.empty()
                : Optional.of(new ValidationException("Product with id " + roomId + " does not exist"));
    }

    public void validateExistsOrThrow(long roomId) {
        exists(roomId).ifPresent(ex -> {
            throw ex;
        });
    }
}

