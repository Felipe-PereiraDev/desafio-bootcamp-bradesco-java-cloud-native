package br.com.bootcamp.repository;

import br.com.bootcamp.entity.Account;
import br.com.bootcamp.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
