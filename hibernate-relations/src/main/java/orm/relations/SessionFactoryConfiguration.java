package orm.relations;

import org.hibernate.SessionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionFactoryConfiguration {


    // @Bean
    // public SessionFactory sessionFactory() {
    //     return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
    //             .addAnnotatedClass(Bar.class)
    //             .addAnnotatedClass(User.class)
    //             .buildSessionFactory();
    // }
}
