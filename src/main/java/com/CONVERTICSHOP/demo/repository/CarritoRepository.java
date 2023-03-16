

package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Carrito;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    /*@Query("FROM CarritoCompra WHERE usuario.id=:id")
    List<Carrito> getByUsuario(Integer idUsuario);*/

  /*  List<Carrito> findCarritoCompraByUsuarioId(Integer id);*/


}
