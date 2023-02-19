package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Integer> {


    Optional<Object> findByIdProducto(Integer idProducto);


}
