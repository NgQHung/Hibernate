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
        props.put(Environment.DIALECT, "org.hibernate..cj.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost/saledb");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "");
        props.put(Environment.SHOW_SQL, "true");

        conf.setProperties(props);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        // provide registry for FACTORY to build
        FACTORY = conf.buildSessionFactory(registry);
    }
}
