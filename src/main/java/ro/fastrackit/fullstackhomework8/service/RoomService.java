package ro.fastrackit.fullstackhomework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fastrackit.fullstackhomework8.model.entity.Room;
import ro.fastrackit.fullstackhomework8.repository.RoomDao;
import ro.fastrackit.fullstackhomework8.repository.RoomRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomDao dao;
    private final RoomValidator validator;

    public List<Room> getAll(int floor) {
        return roomRepository.findByFloor(floor);
    }

    public Room addRoom(Room newRoom) {
        validator.validateNewThrow(newRoom);
        return roomRepository.save(newRoom);
    }

}
