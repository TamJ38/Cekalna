package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false)
    private Professor professor;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne(optional = false)
    private Number number;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Reservation reservation = (Reservation) o;
        return getId() != null && Objects.equals(getId(), reservation.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
