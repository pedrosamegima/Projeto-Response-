package com.ProjetoResponse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoResponse.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {

}
