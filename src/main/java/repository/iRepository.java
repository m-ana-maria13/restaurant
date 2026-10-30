package repository;

import java.util.ArrayList;

public interface IRepository<T> {
    public void save();
    public ArrayList<T> findAll();
    public T findById(String id);
    public void delete();
}
