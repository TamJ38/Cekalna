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
    public  long calculateTime(){
        return Duration.between(from1,to1).toMinutes();
    }
    public TimeTaken(){}
    public TimeTaken(LocalTime from, LocalTime to) {
        this.from1 = from;
        this.to1 = to;
    }
}
