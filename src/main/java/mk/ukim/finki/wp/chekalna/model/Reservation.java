package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne(optional = false)
        private Student student;

        @ManyToOne(optional = false)
        private Professor professor;

        @Column(name = "start_date", nullable = false)
        private LocalTime startDate;

        @Column(name = "end_date", nullable = false)
        private LocalTime endDate;

        @ManyToOne(optional = false)
        private Number number;

    public Reservation(Student student, Professor professor, LocalTime startDate, LocalTime endDate, Number number, Consultation consultation) {
        this.student = student;
        this.professor = professor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
        this.consultation = consultation;
    }

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
