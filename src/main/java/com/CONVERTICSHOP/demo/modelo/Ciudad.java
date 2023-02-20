package com.CONVERTICSHOP.demo.modelo;
import jakarta.persistence.*;

@Entity
@Table (name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_ciudad")
    private int idCiudad;

    @Column (name = "ciudad")
    private String ciudad;

    public Ciudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad() {
    }

    public int getId_ciudad() {
        return idCiudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "id_ciudad=" + idCiudad +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
