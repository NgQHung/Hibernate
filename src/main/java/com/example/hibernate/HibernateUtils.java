package com.example.hibernate;

//import org.hibernate.SessionFactory;

import lombok.Setter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

@Setter
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    // run only once when hibernateUtils is called
    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "sa");
        props.put(Environment.PASS, "123");
        props.put(Environment.SHOW_SQL, "true");
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        // provide registry for FACTORY to build
        FACTORY = conf.buildSessionFactory(registry);
    }
}
