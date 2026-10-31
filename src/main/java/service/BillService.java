package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BillInMemoryRepository;

@Service
public class BillService {
    private final BillInMemoryRepository billRepository;

    @Autowired
    public BillService(BillInMemoryRepository billRepository) {
        this.billRepository = billRepository;
    }


}
