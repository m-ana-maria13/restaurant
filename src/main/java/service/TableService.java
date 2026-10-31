package service;

import model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TableInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {
    private final TableInMemoryRepository  tableRepository;

    @Autowired
    TableService(TableInMemoryRepository tables){
        this.tableRepository = tables;
    }

    public Table occupyTable(String tableId) {
        Table table = tableRepository.findById(tableId);

        if (table == null) {
            throw new IllegalArgumentException("Table does not exist!");
        }

        if ((table.getOccupiedStatus()).equalsIgnoreCase("occupied")) {
            throw new IllegalStateException("Table already occupied!");
        }

        table.setOccupiedStatus("Occupied");
        return tableRepository.save(table);
    }

    public Table releaseTable(String tableId) {
        Table table = tableRepository.findById(tableId);

        if (table == null) {
            throw new IllegalArgumentException("Table does not exist!");
        }

        table.setOccupiedStatus("Free");
        return tableRepository.save(table);
    }

    public Table getTableByNumber(int number) {
        return tableRepository.findByNumber(number);
    }

    public Table getTableById(String id){
        return tableRepository.findById(id);
    }

    public List<Table> getAllTables(){
        return tableRepository.findAll();
    }



    public List<Table> getAvailableTables() {
        List<Table> available = new ArrayList<>();
        for (Table table : tableRepository.findAll()) {
            if ((table.getOccupiedStatus()).equalsIgnoreCase("Free")) {
                available.add(table);
            }
        }
        return available;
    }
}
