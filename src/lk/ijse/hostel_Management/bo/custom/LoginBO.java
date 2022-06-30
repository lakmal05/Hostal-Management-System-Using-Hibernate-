package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.bo.SuperBO;

public interface LoginBO extends SuperBO {

    boolean checkCredentials(String userName, String password) throws Exception;

}
