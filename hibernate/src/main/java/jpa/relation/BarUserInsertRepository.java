package jpa.relation;

import jpa.relation.transaction.BarUserTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BarUserInsertRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // public void insert(BarUserTransaction barUserTransaction) {
    //     Session session = sessionFactory.openSession();
    //     Transaction tx = session.beginTransaction();
    //     session.save(barUserTransaction.getBar());
    //     barUserTransaction.getUsers().forEach(session::save);
    //     tx.commit();
    //     session.close();
    // }

    public void insert(BarUserTransaction barUserTransaction) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(barUserTransaction.getBar());
        barUserTransaction.getUsers().forEach(session::save);
        tx.commit();
    }

}
