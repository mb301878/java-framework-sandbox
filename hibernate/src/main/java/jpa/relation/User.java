package jpa.relation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "bar_id", nullable = false)
    private Bar bar;

    public static User newInstanceOfUserWithNoBar(int userId) {
        User user = new User();
        user.setUserId((long) userId);
        return user;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }
}
