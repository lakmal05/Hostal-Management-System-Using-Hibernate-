package lk.ijse.hostel_Management.util;

import lk.ijse.hostel_Management.entity.Student;


import java.io.IOException;
import java.util.Properties;



import lk.ijse.hostel_Management.entity.RoomReservation;
import lk.ijse.hostel_Management.entity.Room;

import lk.ijse.hostel_Management.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration () throws IOException {
    Configuration configuration= new Configuration();
    Properties properties = new Properties();



        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        configuration.setProperties(properties);

    // configuration.addAnnotatedClass();
        configuration.addAnnotatedClass(Student.class).addAnnotatedClass(Room.class).addAnnotatedClass(RoomReservation.class).addAnnotatedClass(User.class);

    sessionFactory = configuration.buildSessionFactory();
}

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}
