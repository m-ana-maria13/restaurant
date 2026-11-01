package service;

import model.Staff;
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
        Table table = existingTable(tableId);

        if ((table.getOccupiedStatus()).equalsIgnoreCase("occupied")) {
            throw new IllegalStateException("Table already occupied!");
        }

        table.setOccupiedStatus("Occupied");
        return tableRepository.save(table);
    }

    public Table releaseTable(String tableId) {
        Table table = existingTable(tableId);

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

    private Table existingTable(String id) {
        Table table = tableRepository.findById(id);
        if (table == null) {
            throw new IllegalArgumentException("Id not valid!");
        }
        return table;
    }
}
