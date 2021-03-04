package com.example.sweater.domain;

import javax.persistence.*;
import  lombok.*;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Transaction() {
    }

    public Transaction(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }
}