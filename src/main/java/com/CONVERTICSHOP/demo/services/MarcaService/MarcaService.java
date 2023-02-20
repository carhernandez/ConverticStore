package com.CONVERTICSHOP.demo.services.MarcaService;

import com.CONVERTICSHOP.demo.modelo.Marca;

import java.util.List;

public interface MarcaService {

    List<Marca> obtenerTodos();

    Marca obtenerMarcaPorId(Integer idMarca);

    Marca guardarMarca(Marca marca);

    Marca actualizarMarca(Marca marca);

    void borrar(Integer idMarca);


}
