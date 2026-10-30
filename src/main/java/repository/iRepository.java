package repository;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {
    public T save();
    public List<T> findAll();
    public T findById(String id);
    public Boolean delete();
}
