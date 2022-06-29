package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.LoginBO;
import lk.ijse.hostel_Management.dao.DAOFactory;
import lk.ijse.hostel_Management.dao.custom.UserDAO;

import java.util.HashMap;

public class LoginBOImpl implements LoginBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean checkCredentials(String userName, String password) throws Exception {
        HashMap<String, String> allUsers = userDAO.getAllUserNPasswordMap();
        if (allUsers.containsKey(userName)) {
            return allUsers.get(userName).equals(password);
        } else {
            return false;
        }


    }
}
