package lk.ijse.hostel_Management.bo.custom;

import java.util.ArrayList;

public interface UserBO {
    boolean saveUser(UserDTO dto) throws Exception;

    boolean updateUser(UserDTO dto) throws Exception;

    boolean deleteUser(String id) throws Exception;

    UserDTO getUser(String id) throws Exception;

    ArrayList<UserDTO> getAllUsers() throws Exception;

    ArrayList<UserDTO> getMatchingUsers(String search) throws Exception;



}
