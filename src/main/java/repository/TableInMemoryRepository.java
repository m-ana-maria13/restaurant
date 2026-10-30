package repository;

import model.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableInMemoryRepository extends InMemoryRepository<Table> {

    @Override
    protected String getId(Table entity) {
        return entity.getId();
    }

    public Table findByNumber(int number){
        for (Table table : entities) { // daca entities era private nu aveam acces
            if (number == table.getNumber()) {
                return table;
            }
        }
        return null;
    }
}
