// package jpa.relation;
//
// import org.hibernate.SessionFactory;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import javax.persistence.EntityManagerFactory;
//
// @Configuration
// @EnableAutoConfiguration
// public class SessionFactoryConfiguration {
//
//     @Bean
//     public SessionFactory setSessionFactory(EntityManagerFactory entityManagerFactory) {
//         return entityManagerFactory.unwrap(SessionFactory.class);
//     }
// }
