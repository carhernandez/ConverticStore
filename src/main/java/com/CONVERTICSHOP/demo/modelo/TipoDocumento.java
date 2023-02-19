package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;
    @Column (name = "documento")
    private String documento;

    /*@OneToMany (mappedBy = "tipoDocumento", cascade = CascadeType.ALL)
    @JoinColumn(table = "usuario", referencedColumnName = "id_usuario")
    private <Usuario> usuarios;*/

    public TipoDocumento() {
    }

    public TipoDocumento(String documento, List<Usuario> usuarios) {
        this.documento = documento;
       /* this.usuarios= usuarios;*/
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

   /* public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }*/


}
