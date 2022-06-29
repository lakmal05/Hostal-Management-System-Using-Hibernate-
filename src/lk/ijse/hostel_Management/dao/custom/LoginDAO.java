package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.SuperDAO;
import lk.ijse.hostel_Management.entity.User;

import java.util.List;

public interface LoginDAO extends SuperDAO {
    List<User> getAllUsers();

}
