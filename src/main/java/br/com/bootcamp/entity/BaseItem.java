package br.com.bootcamp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected String icon;

    @Column(nullable = false, unique = true)
    protected String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    protected User user;
}
