package com.cross.bookmanager.service;

import com.cross.bookmanager.dao.CartDao;
import com.cross.bookmanager.model.Cart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private CartDao cartDao;
    @Override
    @Transactional
    public void addBookCart(Cart cart) {
        this.cartDao.addBookCart(cart);
    }

    @Override
    @Transactional
    public List<Cart> listCart() {
        return this.cartDao.listCart();
    }

    public void setCartDao(com.cross.bookmanager.dao.CartDaoImpl cartDao) {
    }
}
