package repository;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {
    T save(T entity);
    List<T> findAll();
    T findById(String id);
    boolean delete(T entity);
}
