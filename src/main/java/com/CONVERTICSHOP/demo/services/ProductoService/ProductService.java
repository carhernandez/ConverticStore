package com.CONVERTICSHOP.demo.services.ProductoService;

import com.CONVERTICSHOP.demo.modelo.Producto;

import java.util.List;
import java.util.Optional;

//Una interface y una implementación te permiten construir lógica de negocio, hacer validaciones
//y procesar lo que necesites. El repository sólo debería encargarse de la comunicación con base de datos

public interface ProductService {

    List<Producto> obtenerTodos() throws Exception;

    Producto crearProducto(Producto producto) throws Exception;

    Producto actualizarProducto(Integer idProducto) throws Exception;


    String borrarProducto (Integer idTipoDocumento) throws Exception;

    Optional<Producto> obtenerProductoPorId(int idProducto);


}
