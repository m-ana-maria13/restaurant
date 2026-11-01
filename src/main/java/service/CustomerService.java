package service;


import model.Customer;
import model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerInMemoryRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerInMemoryRepository customerRepository;

    @Autowired
    public CustomerService(CustomerInMemoryRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public Customer registerCustomer(Customer customer){
        if(customer==null || customer.getId()==null){
            throw new IllegalArgumentException("Client invalid");
        }
        if(customer.getDiscount()<0 || customer.getDiscount()>70){
            throw new IllegalArgumentException("Discount between 0%-70%");
        }

        return customerRepository.save(customer);
    }


    public Customer updateDiscount(String customerId, int discount){
        Customer customer= customerRepository.findById(customerId);
        if(customer==null ){
            throw new IllegalArgumentException("Client not found!");
        }
        if(discount<0 || discount>70){
            throw new IllegalArgumentException("Discount between 0%-70%");
        }
        customer.setDiscount(discount);
        return customerRepository.save(customer);
    }



    public Customer getCustomerById(String customerId){
        return customerRepository.findById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }


}
