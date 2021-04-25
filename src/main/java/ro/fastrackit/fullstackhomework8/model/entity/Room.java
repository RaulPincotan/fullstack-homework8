package ro.fastrackit.fullstackhomework8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @OneToOne
            (cascade = CascadeType.PERSIST)
    RoomFacilities roomFacilities;
    @Id
    @GeneratedValue
    private Long id;
    private String roomNUmber;
    private int floor;
    private String hotelName;

}
