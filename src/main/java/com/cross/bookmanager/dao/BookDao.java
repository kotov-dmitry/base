package com.cross.bookmanager.dao;

import com.cross.bookmanager.model.Book;

import java.util.List;

public interface BookDao {
    void addBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();

    void updateBook(Book book);
}
