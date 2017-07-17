package com.cross.bookmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "user_id")
    private int user_id;

    @Column (name = "book_id")
    private int book_id;
}
