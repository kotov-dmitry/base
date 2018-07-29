package com.cross.bookmanager.service;

import com.cross.bookmanager.model.Book;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void removeBook(int id);

    public void updateBook(Book book);

    public Book getBookById(int id);

    public List<Book> listBooks();
}
