package com.CONVERTICSHOP.demo.services.ProductoService;

import com.CONVERTICSHOP.demo.modelo.Producto;

import java.util.List;

//Una interface y una implementación te permiten construir lógica de negocio, hacer validaciones
//y procesar lo que necesites. El repository sólo debería encargarse de la comunicación con base de datos

public interface ProductoService {

    List<Producto> obtenerTodos() throws Exception;

    Producto crearProducto(Producto producto) throws Exception;

    Producto actualizarProducto(Integer idProducto) throws Exception;


    String borrarProducto (Integer idTipoDocumento) throws Exception;

    Producto obtenerProductoPorGenero(Integer IdGenero) throws Exception;


}
