package jpa.relation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static jpa.relation.Bar.newInstanceOfBarWithNoUsers;

@Repository
@Component
public class BarUserInsertRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void insertUsersForBar(Collection<User> userIds, int barId) {

        // Set<User> users = userIds.stream()
        //         .map(User::newInstanceOfUserWithNoBar)
        //         .collect(Collectors.toSet());
        //
        // Bar bar = newInstanceOfBarWithNoUsers(barId);
        //
        // bar.setUsers(users);
        // users.forEach();
        //
        // Session session = sessionFactory.getCurrentSession();
        // Transaction tx = session.beginTransaction();
        //
        // users.forEach(session::save);
        // // bars.forEach(session::save);
        //
        // tx.commit();
    }

}
