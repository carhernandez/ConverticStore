package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {



}
