package com.cross.bookmanager.service;

import com.cross.bookmanager.dao.OrderDao;
import com.cross.bookmanager.model.Order;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Cross on 10.07.2017.
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        this.orderDao.addOrder(order);
    }
}
