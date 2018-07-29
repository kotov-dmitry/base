package com.cross.bookmanager.controller;

import com.cross.bookmanager.model.Cart;
import com.cross.bookmanager.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class CartController {
    @Resource(name = "cartService")
    private CartService cartService;

    @Autowired(required = true)
    @Qualifier(value = "cartService")
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("cart", new Cart());
        model.addAttribute("cartList", this.cartService.listCart());
        return "cart";
    }

    @RequestMapping(value = "/addOrderInCart/{book_id}/{username}")
    public String addOrderInCart(@PathVariable("book_id") int book_id,
                                 @PathVariable("username") String username){
        Cart cart = new Cart();
        cart.setBook_id(book_id);
        cart.setUsername(username);
        cartService.addBookCart(cart);
        return "/books";
    }

    @RequestMapping(value = "/removeOrderCart/{id}")
    public String removeOrderCart(@PathVariable("id") int id){
        this.cartService.removeOrderCart(id);
        return "redirect:/cart";
    }
}
