package com.CONVERTICSHOP.demo.services.CarritoService;

import com.CONVERTICSHOP.demo.modelo.Carrito;

import java.util.List;

public interface CarritoService {

    Carrito registrarProducto(Carrito carrito) throws Exception;

    List<Carrito> obtenerCarritoPorUsuarioId(Integer idUsuario) throws Exception;

    void delete(Integer idUsuario) throws Exception;

    void actualizarInventario(Integer id) throws Exception;


}
