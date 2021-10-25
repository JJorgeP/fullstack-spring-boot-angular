package com.jjp.money.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjp.money.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
