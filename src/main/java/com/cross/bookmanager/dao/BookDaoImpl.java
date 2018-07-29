package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private EntityManager em;

    @Override
    public void addBook(Book book) {
        em.persist(book);
        logger.info("Book successfully saved. Book details: " + book);

    }

    @Override
    public void removeBook(int id) {
        Book book = em.find(Book.class, id);

        if (book != null) {
            em.remove(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Book book = em.find(Book.class, id);
        logger.info("Book successfully loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        List<Book> bookList = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();

        for(Book book: bookList){
            logger.info("Book list: " + book);
        }

        return bookList;
    }

    @Override
    public void updateBook(Book book){
        em.merge(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
