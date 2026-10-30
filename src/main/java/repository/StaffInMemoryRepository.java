package repository;

import java.util.List;

public class StaffInMemoryRepository implements IRepository {


    @Override
    public Object save() {
        return null;
    }

    @Override
    public List findAll() {
        return List.of();
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }
}