package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    /*@Query("FROM Producto where genero.genero = :genero")*/
    List<Producto> getByGenero_idGenero (Integer idGenero);
}
