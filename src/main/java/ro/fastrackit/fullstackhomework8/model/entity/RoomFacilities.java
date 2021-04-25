package ro.fastrackit.fullstackhomework8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomFacilities {
    @Id
    @GeneratedValue
    private Long id;
    private boolean tv;
    private boolean doubleBed;
}
