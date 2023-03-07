package com.CONVERTICSHOP.demo.services.TallaService;

import com.CONVERTICSHOP.demo.modelo.Producto;
import com.CONVERTICSHOP.demo.modelo.Talla;
import com.CONVERTICSHOP.demo.repository.TallaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tallaServiceImpl implements TallaService  {

    @Autowired private TallaRepository tallaRepository;

    @Override
    @Transactional
    public List<Talla> obtenerTodos() throws Exception {
        return tallaRepository.findAll();
    }

    @Override
    public Talla crearTalla(Talla talla) throws Exception {
        return null;
    }

    @Override
    public Talla actualizarTalla(Integer idTalla) throws Exception {
        return null;
    }

    @Override
    public String borrarTalla(Integer idTalla) throws Exception {
        return null;
    }
}
