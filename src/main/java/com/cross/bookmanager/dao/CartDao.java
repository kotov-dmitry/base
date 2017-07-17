package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Cart;

import java.util.List;

public interface CartDao {
    void addBookCart(Cart cart);
    List<Cart> listCart();
}
