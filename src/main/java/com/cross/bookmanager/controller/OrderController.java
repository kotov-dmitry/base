package com.cross.bookmanager.controller;

import com.cross.bookmanager.model.Order;
import com.cross.bookmanager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired(required = true)
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order){

        if(order.getId()== 0){
            this.orderService.addOrder(order);
        }
        return "redirect:/orders";
    }
    @RequestMapping(value = "orders/{id}", method = RequestMethod.GET)
    public String order(Model model,@PathVariable("id") int id){
        model.addAttribute("order", new Order(id));
        return "orders";
    }
}
