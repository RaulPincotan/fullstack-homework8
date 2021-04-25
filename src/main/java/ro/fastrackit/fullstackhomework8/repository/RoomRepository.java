package ro.fastrackit.fullstackhomework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastrackit.fullstackhomework8.model.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByFloor(int floor);

    boolean findByNumber(String roomNUmber);
}
