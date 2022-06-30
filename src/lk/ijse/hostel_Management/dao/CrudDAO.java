package lk.ijse.hostel_Management.dao;

import java.io.IOException;
import java.util.List;

public interface CrudDAO <T,ID> extends SuperDAO{
    List<T> getAll() throws Exception; //

    boolean save(T entity) throws Exception;//

    boolean update(T entity) throws Exception;//

    boolean delete(ID id) throws Exception;//

    boolean exist(ID id) throws IOException;

    T search(ID id) throws IOException;//Get


}
