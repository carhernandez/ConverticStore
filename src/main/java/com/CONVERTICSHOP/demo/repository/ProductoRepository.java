package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> getByGenero_idGenero (Integer idGenero);

    // @Query("SELECT p FROM Producto p WHERE (LOWER(p.descripcion) LIKE LOWER(CONCAT('%',?1,'%'))  " +
    //            "OR LOWER(p.color) LIKE LOWER(CONCAT('%',?1,'%') ) OR LOWER(p.marca)
    //            LIKE LOWER(CONCAT('%',?1,'%') )) AND p.genero = ?2  ")
    List<Producto> getProductoByDescripcionOrColor_colorOrMarca_idMarca(String descripcion, String color, String marca);

    @Query("FROM Producto where genero.genero = :genero")
    List<Producto> getByGenero(String genero);



    List<Producto> findTop4ByOrderByMasBuscadosDesc();
}
