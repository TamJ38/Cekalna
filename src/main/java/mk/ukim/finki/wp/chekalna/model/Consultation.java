package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;
import org.hibernate.Hibernate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consultation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Room room;

    @Enumerated(EnumType.STRING)
    private ConsultationType type;

    private LocalDate oneTimeDate;

    @Enumerated(EnumType.STRING)
    private DayOfWeek weeklyDayOfWeek;

    private LocalTime startTime;

    private LocalTime endTime;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Consultation that = (Consultation) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

