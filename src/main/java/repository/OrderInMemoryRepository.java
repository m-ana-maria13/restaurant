package repository;

import model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderInMemoryRepository extends InMemoryRepository<Order>{

    @Override
    public String getId(Order entity) {

        return entity.getId();
    }
}
