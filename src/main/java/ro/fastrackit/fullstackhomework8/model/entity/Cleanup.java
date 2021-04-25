package ro.fastrackit.fullstackhomework8.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cleanup {
    @OneToMany(cascade = CascadeType.PERSIST)
    List<CleaningProcedure> procedures;
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Room room;


}
