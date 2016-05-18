package Metodista_DataAccess.PAP_Metodista_Dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface IDaoBase<T> {

    public boolean delete(T businessObjetc);

    public T get(Serializable id);

    public List<T> list();

    public boolean save(T businessObject);

    public boolean update(T businessObject);

    public ResultSet executeQuery(String sql);
}
