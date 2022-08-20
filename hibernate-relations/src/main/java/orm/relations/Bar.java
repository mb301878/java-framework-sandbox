package orm.relations;

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
    private Long barId;
    @OneToMany(mappedBy = "bar")
    private Set<User> users;

    public static Bar newInstanceOfBarWithNoUsers(int barId) {
        Bar bar = new Bar();
        bar.setBarId((long) barId);
        return bar;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Bar bar = (Bar) o;
        return barId != null && Objects.equals(barId, bar.barId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
