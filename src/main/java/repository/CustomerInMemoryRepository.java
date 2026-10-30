package repository;

import model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerInMemoryRepository extends InMemoryRepository<Customer>{
    @Override
    protected String getId(Customer entity) {
         return entity.getId();
    }
}
