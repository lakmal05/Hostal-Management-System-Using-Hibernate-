package lk.ijse.hostel_Management.dao.custom;


import lk.ijse.hostel_Management.dao.CrudDAO;
import lk.ijse.hostel_Management.entity.Student;
import lk.ijse.hostel_Management.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User>getMatchingResults(String search)throws Exception;

    HashMap<String ,String>getAllUserNPasswordMap()throws Exception;

}
