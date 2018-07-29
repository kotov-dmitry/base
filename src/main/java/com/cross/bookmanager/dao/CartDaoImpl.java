package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Book;
import com.cross.bookmanager.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBookCart(Cart cart) {
        Session session =this.sessionFactory.getCurrentSession();
        session.persist(cart);
        logger.info("Cart successfully saved. Cart details: " + cart);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Cart> listCart() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Cart> cartList = session.createQuery("from Cart").list();

        for (Cart aCartList : cartList) {
            aCartList.setBook(getBookById(aCartList.getBook_id()));
        }

        for(Cart cart: cartList){
            logger.info("Cart list: " + cart);
        }

        return cartList;
    }

    @Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    public void removeOrderCart(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.load(Cart.class, new Integer(id));

        if(cart!=null){
            session.delete(cart);
        }
        logger.info("Cart successfully removed. Cart details: " + cart);
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
    }
}
