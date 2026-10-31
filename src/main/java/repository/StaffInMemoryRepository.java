package repository;

import model.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffInMemoryRepository extends InMemoryRepository<Staff>{

    @Override
    public String getId(Staff entity) {
        return entity.getId();
    }
}