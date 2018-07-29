package com.cross.bookmanager.service;


import com.cross.bookmanager.model.Cart;

import java.util.List;

public interface CartService {
    void addBookCart(Cart cart);
    List<Cart> listCart();
    void removeOrderCart(int id);
}
