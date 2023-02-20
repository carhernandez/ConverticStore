package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Talla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Integer> {

    /*@Query("FROM ProductoTalla WHERE producto.genero.descripcion=:descripcion")
    List<Talla> getByProductoGenero(String descripcion);*/

}
