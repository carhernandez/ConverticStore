package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "correo", nullable = false)
    @Email(message = "Por favor ingrese un correo electronico valido")
    private String correo;
    @ManyToOne(targetEntity = TipoDocumento.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_documento", referencedColumnName = "id_tipo_documento")
    TipoDocumento tipoDocumento;

    @Column(name = "n_documento", nullable = false)
    private Integer nDocumento;

    @Pattern(regexp = "[a-zA-Z\\s]+", message = "nombres solo se permiten letras y espacios")
    @Column(name = "nombres", nullable = false)
    private String nombres;
    @Pattern(regexp = "[a-zA-Z\\s]+",message = "apellidos solo se permiten letras y espacios")
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "contrasena", nullable = false)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[!#$%&*@?])(?!\\s)[a-zA-Z\\d!#$%&*@?]{5,16}$",
     message = "contraseña debe ser de longitud mínima 5, y debe contener letras mayúsculas,\\n" +
    "letras minúsculas y números.\n")
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String correo, TipoDocumento tipoDocumento, Integer nDocumento,
                   String nombres, String apellidos, String contrasena, List<Producto> productos) {
        this.correo = correo;
        this.tipoDocumento = tipoDocumento;
        this.nDocumento = nDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;

    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getnDocumento() {
        return nDocumento;
    }

    public void setnDocumento(Integer nDocumento) {
        this.nDocumento = nDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correoElectronico='" + correo + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", nDocumento=" + nDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }


}
