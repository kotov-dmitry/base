package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository("OrderDao")
public class OrderDaoImpl implements OrderDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    private EntityManager em;
    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void addOrder(Order order) {
        em.persist(order);
        logger.info("Order successfully saved. Order details: " + order);
    }
}
