package lk.ijse.hostel_Management.bo.custom.impl;

import lk.ijse.hostel_Management.bo.custom.KeyMoneyDetailsBO;
import lk.ijse.hostel_Management.dao.DAOFactory;
import lk.ijse.hostel_Management.dao.custom.QuarryDAO;


import java.util.List;

public class KeyMoneyDetailsBOImpl implements KeyMoneyDetailsBO {

    private final QuarryDAO queryDAO =  (QuarryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<Object[]> getKeyMoneyAndStudentDetails() {
        return queryDAO.getKeyMoneyAndStudentDetails();
    }

}
