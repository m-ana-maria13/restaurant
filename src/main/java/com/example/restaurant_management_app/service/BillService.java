package com.example.restaurant_management_app.service;


import com.example.restaurant_management_app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restaurant_management_app.repository.BillInMemoryRepository;
import com.example.restaurant_management_app.repository.CustomerInMemoryRepository;
import com.example.restaurant_management_app.repository.MenuItemInMemoryRepository;
import com.example.restaurant_management_app.repository.OrderInMemoryRepository;

import java.util.List;

@Service
public class BillService {
    private final BillInMemoryRepository billRepository;
    private final OrderInMemoryRepository orderRepository;
    private final CustomerInMemoryRepository customerRepository;
    private final MenuItemInMemoryRepository menuItemRepository;
    private final TableService tableService;

    @Autowired
    public BillService(BillInMemoryRepository billRepository, OrderInMemoryRepository orderRepository,
                       CustomerInMemoryRepository customerRepository,
                       MenuItemInMemoryRepository menuItemRepository,TableService tableService) {
        this.billRepository = billRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
        this.tableService=tableService;
    }


    public Bill generateBill(String orderId){
        Order order=orderRepository.findById(orderId);
        if(order==null){
            throw new IllegalArgumentException("Order not found!");
        }
        double subtotal=0.0;
        if(order.getOrderLines() != null){
            for(OrderLine line : order.getOrderLines()){
                MenuItem item= menuItemRepository.findById(line.getMenuItemId());
                if(item != null){
                    subtotal += (item.getPrice()*line.getQuantity());
                }
            }
        }
        double discount=0.0;
        if(order.getCustomerId() != null){
            Customer customer= customerRepository.findById(order.getCustomerId());
            if ( customer!=null && customer.getDiscount()>0){
                discount= customer.getDiscount();
            }
        }

        double total= subtotal-((discount/100)*subtotal);
        Bill bill= new Bill(orderId,total);
        return billRepository.save(bill);
    }


    public Order payBill(String orderId){
        if(orderId==null){
            throw new IllegalArgumentException("OrderId null!");
        }
        Order order= orderRepository.findById(orderId);
        if(order==null){
            throw new IllegalArgumentException("Order null!");
        }
        order.setStatus("Paid");
        orderRepository.save(order);

        if(!order.getTakeAway() && order.getTableId()!=null){
            tableService.releaseTable(order.getTableId());
        }
        return order;
    }

    public Bill getBillById(String id){
        return billRepository.findById(id);
    }

    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }
}
