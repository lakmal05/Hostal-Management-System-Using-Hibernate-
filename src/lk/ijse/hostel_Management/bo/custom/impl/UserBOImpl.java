package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.UserBO;
import lk.ijse.hostel_Management.dao.DAOFactory;
import lk.ijse.hostel_Management.dao.custom.UserDAO;
import lk.ijse.hostel_Management.dto.UserDTO;
import lk.ijse.hostel_Management.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserBOImpl implements UserBO {

    UserDAO uDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public boolean saveUser(UserDTO dto) throws Exception {
        return uDAO.save(new User(dto.getNic(), dto.getName(), dto.getUserName(), dto.getPassword()));
    }

    @Override
    public boolean updateUser(UserDTO dto) throws Exception {
        return uDAO.update(new User(dto.getNic(), dto.getName(), dto.getUserName(), dto.getPassword()));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return uDAO.delete(id);
    }

    @Override
    public UserDTO getUser(String id) throws Exception {
        User user = uDAO.search(id);
        return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() throws Exception {
        List<User> all = uDAO.getAll();
        ArrayList<UserDTO> allUsers = new ArrayList<>();
        allUsers.addAll(all.stream().map((Function<? super User, UserDTO>) user -> {
            return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
        }).collect(Collectors.toList()));
        return allUsers;
    }

    @Override
    public ArrayList<UserDTO> getMatchingUsers(String search) throws Exception {
        List<User> all = uDAO.getMatchingResults("%" + search + "%");
        ArrayList<UserDTO> allUsers = new ArrayList<>();
        allUsers.addAll(all.stream().map((Function<? super User, UserDTO>) user -> {
            return new UserDTO(user.getNic(), user.getName(), user.getUserName(), user.getPassword());
        }).collect(Collectors.toList()));
        return allUsers;
    }


}
