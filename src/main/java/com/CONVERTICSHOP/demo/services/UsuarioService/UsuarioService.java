package com.CONVERTICSHOP.demo.services.UsuarioService;

import com.CONVERTICSHOP.demo.modelo.Usuario;

import java.util.List;


public interface UsuarioService  {

    List<Usuario> obtenerTodos() throws Exception;

    Usuario crearUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Integer idUsuario);


    String borrarUsuario (Integer IdUsuario) throws Exception;

    Usuario obtenerUsuarioPorId(int idUsuario);

   Boolean Login (String correoElectronico, String contrasena) throws Exception;


}
