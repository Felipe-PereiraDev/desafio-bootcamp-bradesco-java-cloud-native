package br.com.bootcamp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    @OneToOne(mappedBy = "account")
    private User user;


    public Account(String number, User user) {
        this.number = number;
        this.agency = "0001";
        this.balance = BigDecimal.valueOf(0);
        this.limit = BigDecimal.valueOf(1000);
        this.user = user;
    }
}
