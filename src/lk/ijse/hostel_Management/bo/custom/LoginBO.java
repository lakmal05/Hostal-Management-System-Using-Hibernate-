package lk.ijse.hostel_Management.bo.custom;

public interface LoginBO {

    boolean checkCredentials(String userName, String password) throws Exception;

}
