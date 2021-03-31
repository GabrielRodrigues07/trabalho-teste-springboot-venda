package com.exampleteste.trabalhoteste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleteste.trabalhoteste.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
