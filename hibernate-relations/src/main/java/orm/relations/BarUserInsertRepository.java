package orm.relations;

import orm.relations.transaction.BarUserTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Component
@Transactional
public class BarUserInsertRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(BarUserTransaction barUserTransaction) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(barUserTransaction.getBar());
        barUserTransaction.getUsers().forEach(session::save);
        tx.commit();
    }


}
