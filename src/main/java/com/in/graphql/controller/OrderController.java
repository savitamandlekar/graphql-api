package com.in.graphql.controller;


import com.in.graphql.entites.Order;
import com.in.graphql.entites.User;
import com.in.graphql.services.OrderService;
import com.in.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    private UserService userService;
    private OrderService orderService;

    private OrderController(UserService userService,OrderService orderService){
        this.userService=userService;
        this.orderService=orderService;
    }

    //CreateOrder

    @MutationMapping
    public Order createOrder(
            @Argument String orderDetail,
            @Argument String address,
            @Argument int price,
            @Argument int userId
    ){

        User user=userService.getUser(userId);

 Order order=new Order();
 order.setOrderDetail(orderDetail);
 order.setAddress(address);
 order.setPrice(price);
 order.setUser(user);

 Order order1=orderService.createOrder(order);
 return order1;

    }

    //get OrderS
    @QueryMapping
    public List<Order> getOrders(){
        return  orderService.getAllOrder();
    }

    //Get order

    @QueryMapping
    public Order getOrder(@Argument int orderId){
        return  orderService.getOrder(orderId);
    }


    @MutationMapping
    public Boolean deleteOrder(@Argument int orderId){
        return  orderService.deleteOrder(orderId);
    }
}
