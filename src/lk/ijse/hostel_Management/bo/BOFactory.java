package lk.ijse.hostel_Management.bo;

import lk.ijse.hostel_Management.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public enum BOTypes {
        LOGIN, MANAGESTUDENTS, MANAGEROOMS, MAKERESERVATION, RESERVATIONDETAILS, USER, KEYMONEYREMAINSTUDENTS

    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case LOGIN:
                return new LoginBOImpl();
            case MANAGESTUDENTS:
                return new StudentDetailsBOImpl();
            case MANAGEROOMS:
                return new RoomsBOImpl();
            case MAKERESERVATION:
                return new MakeReservationBOImpl();
            case RESERVATIONDETAILS:
          /     return new ReservationDetailsBOImpl();
            case USER:
                return new UserBOImpl();
            case KEYMONEYREMAINSTUDENTS:
                return new KeyMoneyDetailsBOImpl();
            default:
                return null;

        }
    }











}
