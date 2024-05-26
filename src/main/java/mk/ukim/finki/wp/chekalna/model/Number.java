package mk.ukim.finki.wp.chekalna.model;

import jakarta.persistence.*;
import lombok.*;
import mk.ukim.finki.wp.chekalna.model.enums.NumberStatus;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NumberStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Number number = (Number) o;
        return getId() != null && Objects.equals(getId(), number.getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
