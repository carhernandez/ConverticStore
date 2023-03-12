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








/*
    @Override
    @Transactional
    public Usuario borrarUsuario(Usuario usuario1) {
        Usuario usuario = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idUsuarios));


        usuario.setCorreoElectronico(usuario1.getCorreoElectronico());
        *//*usuario.setTipoDocumento(usuario1.getTipoDocumento());*//*
        usuario.setnDocumento(usuario1.getnDocumento());
        usuario.setNombres(usuario1.getNombres());
        usuario.setApellidos(usuario1.getApellidos());
        usuario.setContrasena(usuario1.getContrasena());

        return null;
    }*/

    /*public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
    }

    public void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public Optional<Usuario> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }*/

        /*String correoElectronico;
        Integer tipoDocumento;
        Integer nDocumento;
        String nombres;
        String apellidos;
        String contrasena;*/


/*

    // obtener todos los usuario
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    // crear usuario rest api

    public ResponseEntity<Usuario> createUsuarios(Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);    }



    // obtener usuario por id rest api
    public ResponseEntity<Usuario> getUsuariosById(Integer idUsuarios) {
        Usuario usuario = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuario);
    }

    // actualizar usuario rest api
    public ResponseEntity<Usuario> updateUsuarios(int idUsuarios, Usuario usuario1) {
        Usuario usuario = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idUsuarios));


        usuario.setCorreoElectronico(usuario1.getCorreoElectronico());
        */
    /*usuario.setTipoDocumento(usuario1.getTipoDocumento());*//*

        usuario.setnDocumento(usuario1.getnDocumento());
        usuario.setNombres(usuario1.getNombres());
        usuario.setApellidos(usuario1.getApellidos());
        usuario.setContrasena(usuario1.getContrasena());

        Usuario updateUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updateUsuario);
    }

    // borrar usuario rest api
    public ResponseEntity<Map<String, Boolean>> deleteUsuario(int idUsuarios) {
        Usuario usuario = usuarioRepository.findByIdUsuario(idUsuarios)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" + idUsuarios));

        usuarioRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<Usuario>> getIdUsuarioAndPassword(int idUsuarios, String contrasena) {
        List<Usuario> usuarios = usuarioRepository.findByIdUsuarioAndContrasena(idUsuarios, contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuarios);
    }

    public ResponseEntity<List<Usuario>> getUsuarioOrNombres(int idUsuarios, String nombres) {
        List<Usuario> usuarios = usuarioRepository.findByIdUsuarioOrNombres(idUsuarios, nombres)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con esa id :" +
                        idUsuarios));
        return ResponseEntity.ok(usuarios);
    }

    */
/*public ResponseEntity<List<Usuario>> getCorreoElectronicoAndContrasena(String correoElectronico,
                                                                            String contrasena) {
        List<Usuario> usuario = (List<Usuario>) usuarioRepository.findByCorreoElectronicoAndContrasena(correoElectronico,
                        contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con ese  :" +
                        correoElectronico));
        return ResponseEntity.ok(usuario);

    }*//*


     */
/* public ResponseEntity<List<Usuario>> getCorreoElectronicoAndContrasena(String correoElectronico, String contrasena) {
        List<Usuario> usuario = (List<Usuario>) usuarioRepository.findByCorreoElectronicoAndContrasena(correoElectronico,
                        contrasena)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no existe con ese  :" +
                        correoElectronico));
        return ResponseEntity.ok(usuario);
    }*/


}

