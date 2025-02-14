package br.com.bootcamp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "news")
public class News extends BaseItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false, unique = true)
    private String description;

    @ManyToOne
    private User user;
}
