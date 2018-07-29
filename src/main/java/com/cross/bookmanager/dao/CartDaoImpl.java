package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

    private EntityManager em;

    @Override
    public void addBookCart(Cart cart) {
        em.persist(cart);
        logger.info("Cart successfully saved. Cart details: " + cart);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cart> listCart() {
        List<Cart> cartList = em.createQuery("from Cart", Cart.class).getResultList();
        for(Cart cart: cartList){
            logger.info("Cart list: " + cart);
        }

        return cartList;
    }

    @Override
    public void removeOrderCart(int id) {
        Cart cart = em.find(Cart.class, id);
        em.remove(cart);
        logger.info("Cart successfully removed. Cart details: " + cart);
    }

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
