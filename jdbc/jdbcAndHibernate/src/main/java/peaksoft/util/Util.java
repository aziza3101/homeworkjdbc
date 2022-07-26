package peaksoft.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

public class Util {
//    private final  Connection connection;
    public static EntityManagerFactory entityManagerFactory=createEntityManagerFactory();

    public static EntityManagerFactory createEntityManagerFactory(){
        Properties properties=new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();

        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }

//    public Util() throws SQLException {
//        connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
//    }
//    public Connection getConnection() {
//
//        return connection;
//    }
}


