package com.CONVERTICSHOP.demo.services.UsuarioService;

import com.CONVERTICSHOP.demo.modelo.Usuario;
import com.CONVERTICSHOP.demo.repository.TipoDocumentoRepository;
import com.CONVERTICSHOP.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuariosServicesImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodos() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional(value = "transactionManager", propagation = Propagation.REQUIRES_NEW, rollbackFor = {Throwable.class})
    public Usuario crearUsuario(Usuario usuario) throws Exception {
        try {
                usuario.setTipoDocumento
                        (tipoDocumentoRepository.findById(usuario.getTipoDocumento().getIdTipoDocumento()).get());
                validarContrasena(usuario.getContrasena());
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void validarContrasena(String contrasena) {

    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(Integer idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idUsuario));
        usuario.setCorreo(usuario.getCorreo());
        usuario.setTipoDocumento(usuario.getTipoDocumento());
        usuario.setnDocumento(usuario.getnDocumento());
        usuario.setNombres(usuario.getNombres());
        usuario.setApellidos(usuario.getApellidos());
        usuario.setContrasena(usuario.getContrasena());

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public String borrarUsuario(Integer IdUsuario) throws Exception {
        try {
        usuarioRepository.findById(IdUsuario)
        .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + IdUsuario));
        usuarioRepository.deleteById(IdUsuario);
        return "se borro el usuario correctamente ";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Usuario obtenerUsuarioPorId(int idUsuario) {
        return null;
    }

    @Override
    public Boolean Login(String correoElectronico, String contrasena) throws Exception {
        try{
            Usuario usuario = usuarioRepository.findByCorreoAndContrasena(correoElectronico, contrasena);
            return usuario!=null;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


}

