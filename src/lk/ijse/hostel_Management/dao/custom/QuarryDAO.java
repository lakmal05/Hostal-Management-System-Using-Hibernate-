package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.SuperDAO;

import java.util.List;

public interface QuarryDAO extends SuperDAO {

    List<Object[]> getKeyMoneyAndStudentDetails();

}
