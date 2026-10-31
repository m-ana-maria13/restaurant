package service;

import model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TableInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableInMemoryRepository  tables;

    @Autowired
    TableService(TableInMemoryRepository tables){
        this.tables = tables;
    }

    public Table occupyTable(String tableId) {
        Table table = tables.findById(tableId);

        if (table == null) {
            throw new IllegalArgumentException("Table does not exist!");
        }

        if ((table.getOccupiedStatus()).equalsIgnoreCase("occupied")) {
            throw new IllegalStateException("Table already occupied!");
        }

        table.setOccupiedStatus("Occupied");
        return tables.save(table);
    }

    public Table releaseTable(String tableId) {
        Table table = tables.findById(tableId);

        if (table == null) {
            throw new IllegalArgumentException("Table does not exist!");
        }

        table.setOccupiedStatus("Free");
        return tables.save(table);
    }

    public Table getTableByNumber(int number) {
        return tables.findByNumber(number);
    }

    public Table getTableById(String id){
        return tables.findById(id);
    }

    public List<Table> getAllTables(){
        return tables.findAll();
    }



    public List<Table> getAvailableTables() {
        List<Table> available = new ArrayList<>();
        for (Table table : tables.findAll()) {
            if ((table.getOccupiedStatus()).equalsIgnoreCase("Free")) {
                available.add(table);
            }
        }
        return available;
    }
}
