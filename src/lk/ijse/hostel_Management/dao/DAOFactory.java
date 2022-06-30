package lk.ijse.hostel_Management.dao;

import lk.ijse.hostel_Management.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        LOGIN,STUDENT,ROOM, RESERVATION,QUERY,USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case LOGIN:
                return new LoginDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new RoomReservationDAOImpl();
            case USER:
                return new UserDAOImpl();
            case QUERY:
                return new QuarryDAOImpl();
            default:
                return null;
        }

    }


}
