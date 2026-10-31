package repository;

import model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillInMemoryRepository extends InMemoryRepository<Bill>{
    @Override
    public String getId(Bill entity) {
        return entity.getId();
    }
}
