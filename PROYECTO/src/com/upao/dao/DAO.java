package com.upao.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Upao
 * @param <T>
 */
public interface DAO<T> {
    public T create(T obj) throws SQLException;
    public T update(T obj) throws SQLException;    
    public T find(int id) throws SQLException;
    public void delete(T obj) throws SQLException;
    public List<T> getAll()throws SQLException;
    
}
