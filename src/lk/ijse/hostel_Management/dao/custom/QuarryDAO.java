package lk.ijse.hostel_Management.dao.custom;

import lk.ijse.hostel_Management.dao.SuperDAO;

import java.io.IOException;
import java.util.List;

public interface QuarryDAO extends SuperDAO {

    List<Object[]> getKeyMoneyAndStudentDetails() throws IOException;

}
