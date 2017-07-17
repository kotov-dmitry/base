package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CartDaoImpl implements CartDao {
    private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);
    private SessionFactory sessionFactory;

    @Override
    public void addBookCart(Cart cart) {
        Session session =this.sessionFactory.getCurrentSession();
        session.persist(cart);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cart> listCart() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cart> cartList = session.createQuery("from Cart").list();

        for(Cart cart: cartList){
            logger.info("Book list: " + cart);
        }

        return cartList;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
    }
}
