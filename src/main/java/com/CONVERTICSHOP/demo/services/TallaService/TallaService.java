package com.CONVERTICSHOP.demo.services.TallaService;

import com.CONVERTICSHOP.demo.modelo.Talla;

import java.util.List;

public interface TallaService {

    List<Talla> obtenerTodos() throws Exception;

    Talla crearTalla(Talla talla) throws Exception;

    Talla actualizarTalla(Integer idTalla) throws Exception;

    String borrarTalla(Integer idTalla) throws Exception;
}
