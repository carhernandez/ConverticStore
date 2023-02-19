package com.CONVERTICSHOP.demo.repository;

import com.CONVERTICSHOP.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    /*

    Optional <List<Usuario>> findByIdUsuarioAndContrasena(int idUsuario, String contrasena );

    Optional <List<Usuario>> findByIdUsuarioOrNombres(int idUsuario, String nombres );

    Usuario borrarUsuario(Usuario idUsuario);


    *//*Optional<Usuario>  findByCorreoElectronicoAndContrasena(String correoElectronico, String contrasena);*/

    Usuario  findByCorreoAndContrasena(String correoElectronico, String contrasena);

}
