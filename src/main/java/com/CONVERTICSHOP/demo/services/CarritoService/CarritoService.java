package com.CONVERTICSHOP.demo.services.CarritoService;

import com.CONVERTICSHOP.demo.modelo.Carrito;

import java.util.List;

public interface CarritoService {

    Carrito obtenerCarrito(Integer idCarrito);

    Carrito registrarCarrito(Carrito carrito) throws Exception;

    /*List<Carrito> obtenerCarritoPorUsuarioId(Integer idUsuario) throws Exception;*/

    void delete(Integer idCarrito) throws Exception;

    void actualizarInventario(Integer id) throws Exception;


}
