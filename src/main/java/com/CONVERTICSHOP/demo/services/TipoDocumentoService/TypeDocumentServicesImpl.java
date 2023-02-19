package com.CONVERTICSHOP.demo.services.TipoDocumentoService;

import com.CONVERTICSHOP.demo.modelo.TipoDocumento;
import com.CONVERTICSHOP.demo.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeDocumentServicesImpl implements TypeDocumentServices {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;


    @Override
    @Transactional (readOnly = true)
    public List<TipoDocumento> obtenerTodos() throws Exception {
        return tipoDocumentoRepository.findAll();
    }

    @Override
    @Transactional
    public TipoDocumento crearTipoDocumento(TipoDocumento tipoDocumento) throws Exception {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    @Override
    @Transactional
    public TipoDocumento actualizarTipoDocumento(Integer idTipoDocumento) throws Exception {
        try {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(idTipoDocumento)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idTipoDocumento));

        tipoDocumento.setDocumento(tipoDocumento.getDocumento());

        return tipoDocumentoRepository.save(tipoDocumento);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public String borrarTipoDocumento(Integer idTipoDocumento) throws Exception {
        try {
            tipoDocumentoRepository.findById(idTipoDocumento)
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idTipoDocumento));
            tipoDocumentoRepository.deleteById(idTipoDocumento);
            return "se borro el usuario correctamente ";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional (readOnly = true)
    public TipoDocumento obtenerTipoDocumentoPorId(int idTipoDocumento) {
        return null;
    }
}









