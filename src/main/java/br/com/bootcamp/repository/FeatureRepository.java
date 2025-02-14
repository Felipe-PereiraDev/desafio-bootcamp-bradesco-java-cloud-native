package br.com.bootcamp.repository;

import br.com.bootcamp.entity.Account;
import br.com.bootcamp.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {
}
