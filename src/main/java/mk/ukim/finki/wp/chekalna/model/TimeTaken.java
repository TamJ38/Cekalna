package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;

@Entity
@Table(name = "time_taken")
public class TimeTaken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime from1;
    private LocalTime to1;
    @ManyToOne
    @JoinColumn(name = "consultation_id", nullable = false)
    private Consultation consultation;

    public long calculateTime() {
        return Duration.between(from1, to1).toMinutes();
    }

    public TimeTaken() {
    }

    public TimeTaken(LocalTime from1, LocalTime to1, Consultation consultation) {
        this.from1 = from1;
        this.to1 = to1;
        this.consultation = consultation;
    }
}
