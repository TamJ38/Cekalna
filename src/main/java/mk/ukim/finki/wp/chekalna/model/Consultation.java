package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.wp.chekalna.model.enums.ConsultationType;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalTime;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConsultationType type;

    @ManyToOne(optional = false)
    private Professor professor;


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

