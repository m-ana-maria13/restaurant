package repository;

import model.MenuItem;
import org.springframework.stereotype.Repository;

@Repository
public class MenuItemInMemoryRepository extends InMemoryRepository<MenuItem>{
    @Override
    protected String getId(MenuItem entity) {
        return entity.getId();
    }
}
