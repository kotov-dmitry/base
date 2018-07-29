package com.cross.bookmanager.service;

import com.cross.bookmanager.dao.CartDao;
import com.cross.bookmanager.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {

    @Autowired
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

    @Override
    @Transactional
    public void removeOrderCart(int id) {
        this.cartDao.removeOrderCart(id);
    }
}
