package jpa.relation;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "bars")
public class Bar {

    @Id
    @Column(name = "bar_id", nullable = false)
    private Integer bar_id;
    @OneToMany(mappedBy = "barId")
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Bar bar = (Bar) o;
        return bar_id != null && Objects.equals(bar_id, bar.bar_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
