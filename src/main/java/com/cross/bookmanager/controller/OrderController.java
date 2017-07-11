package com.cross.bookmanager.controller;

import com.cross.bookmanager.model.Order;
import com.cross.bookmanager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
    private OrderService orderService;

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public void addOrder(@ModelAttribute("order") Order order){
        if(order.getId()== 0){
            this.orderService.addOrder(order);
        }
    }
    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String order(Model model){
        model.addAttribute("order", new Order());
        return "order";
    }
}
