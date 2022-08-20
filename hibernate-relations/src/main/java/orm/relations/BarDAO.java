package orm.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Component
@Transactional
class BarDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Bar getBarByIdd(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Bar.class, id);
    }
}
