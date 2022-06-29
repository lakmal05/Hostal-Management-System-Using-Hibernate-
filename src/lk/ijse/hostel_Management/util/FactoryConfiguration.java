package lk.ijse.hostel_Management.util;

import lk.ijse.hostel_Management.entity.Room;
import lk.ijse.hostel_Management.entity.RoomReservation;
import lk.ijse.hostel_Management.entity.Student;
import lk.ijse.hostel_Management.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;


    private FactoryConfiguration() throws IOException {
        try {
            Configuration configuration = new Configuration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Room.class)
                    .addAnnotatedClass(RoomReservation.class)
                    .addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There is issue in factory Configuration");
        }

    }

    public static FactoryConfiguration getInstance() throws IOException {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }




}
