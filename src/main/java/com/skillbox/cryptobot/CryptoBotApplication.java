package com.skillbox.cryptobot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoBotApplication {

    public static void main(String[] args) {
//        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
//                .configure("hibernate.cfg.xml").build();
//        Metadata metadata = new MetadataSources(standardServiceRegistry)
//                .getMetadataBuilder()
//                .build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//                .build();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();

        SpringApplication.run(CryptoBotApplication.class, args);

//        transaction.commit();
//        sessionFactory.close();


    }

}
