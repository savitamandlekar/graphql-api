package com.in.graphql.services;

import com.in.graphql.entites.Order;
import com.in.graphql.helper.ExceptionHelper;
import com.in.graphql.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    //@Autowired
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo=orderRepo;
    }

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    //get All Order

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    //get single Order

    public Order getOrder(int orderId){
        Order order= orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);

        return order;
    }

    //delete Order

    public boolean deleteOrder(int orderId){
        Order order= orderRepo.findById(orderId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);

        orderRepo.delete(order);
        return true;
    }

}
