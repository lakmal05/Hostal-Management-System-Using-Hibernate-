package lk.ijse.hostel_Management.bo.custom;

import lk.ijse.hostel_Management.bo.SuperBO;

import java.util.List;

public interface KeyMoneyDetailsBO extends SuperBO {

    List<Object[]> getKeyMoneyAndStudentDetails();

}