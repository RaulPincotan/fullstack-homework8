package ro.fastrackit.fullstackhomework8;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.fastrackit.fullstackhomework8.model.entity.*;
import ro.fastrackit.fullstackhomework8.repository.CleanupRepository;
import ro.fastrackit.fullstackhomework8.repository.ReviewRepository;
import ro.fastrackit.fullstackhomework8.repository.RoomRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;
    private final CleanupRepository cleanupRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = roomRepository.saveAll(List.of(
                Room.builder()
                        .roomNUmber("G001")
                        .floor(0)
                        .hotelName("Melody")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(false)
                                .build())
                        .build(),
                Room.builder()
                        .roomNUmber("101")
                        .floor(1)
                        .hotelName("Melody")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(true)
                                .build())
                        .build(),
                Room.builder()
                        .roomNUmber("202")
                        .floor(0)
                        .hotelName("Continental")
                        .roomFacilities(RoomFacilities.builder()
                                .tv(true)
                                .doubleBed(false)
                                .build())
                        .build()
        ));


        List<Review> reviews = reviewRepository.saveAll(List.of(
                Review.builder()
                        .room(rooms.get(0))
                        .mesaj("Great service")
                        .rating(5)
                        .turist("Raul")
                        .build(),
                Review.builder()
                        .room(rooms.get(0))
                        .mesaj("Best hotel in town")
                        .rating(5)
                        .turist("Adrian")
                        .build(),
                Review.builder()
                        .room(rooms.get(1))
                        .mesaj("Great location")
                        .rating(4)
                        .turist("Pincotan")
                        .build()

        ));


        List<Cleanup> cleanups = cleanupRepository.saveAll(List.of(
                Cleanup.builder()
                        .date(LocalDate.of(2019, Month.DECEMBER, 21))
                        .room(rooms.get(0))
                        .procedures(List.of(
                                CleaningProcedure.builder()
                                        .name("Ana")
                                        .outcome(40)
                                        .build(),
                                CleaningProcedure.builder()
                                        .name("Marius")
                                        .outcome(15)
                                        .build()
                        ))
                        .build(),
                Cleanup.builder()
                        .date(LocalDate.of(2020, Month.DECEMBER, 17))
                        .room(rooms.get(1))
                        .procedures(List.of(
                                CleaningProcedure.builder()
                                        .name("Ana")
                                        .outcome(40)
                                        .build(),
                                CleaningProcedure.builder()
                                        .name("Marius")
                                        .outcome(15)
                                        .build()
                        ))
                        .build()
        ));

    }
}
