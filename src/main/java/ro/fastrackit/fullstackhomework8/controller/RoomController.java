package ro.fastrackit.fullstackhomework8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fastrackit.fullstackhomework8.model.entity.Room;
import ro.fastrackit.fullstackhomework8.service.RoomService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

//    @GetMapping
//    List<Room> getAllRooms(RoomFilters filters){
//        return roomService.getAll(filters);
//    }

    @GetMapping
    List<Room> getAll(@RequestParam(required = false) Integer floor) {
        return roomService.getAll(floor);
    }


}
