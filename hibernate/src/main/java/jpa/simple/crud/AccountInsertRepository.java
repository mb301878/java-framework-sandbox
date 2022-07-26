package jpa.simple.crud;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Component
public class AccountInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Account account) {
        entityManager.createNativeQuery("INSERT INTO accounts (user_id, username, password, email, created_on, last_login) VALUES (?,?,?, ?,?,?)")
                .setParameter(1, account.getId())
                .setParameter(2, account.getUsername())
                .setParameter(3, account.getPassword())
                .setParameter(4, account.getEmail())
                .setParameter(5, account.getCreatedOn())
                .setParameter(6, account.getLastLogin())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(Account account) {
        this.entityManager.persist(account);
    }

}


