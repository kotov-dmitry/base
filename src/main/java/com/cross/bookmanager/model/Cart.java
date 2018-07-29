package com.cross.bookmanager.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "username")
    private String username;

    @Column (name = "book_id")
    private int book_id;

    @Transient
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", book_id=" + book_id +
                ", book=" + book +
                '}';
    }
}
