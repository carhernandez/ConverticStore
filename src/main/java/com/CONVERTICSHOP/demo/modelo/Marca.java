package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table (name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private int idMarca;

    @Column(name = "marca")
    private String marca;

    public Marca(String marca) {
        this.marca = marca;
    }

    public Marca() {
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", marca='" + marca + '\'' +
                '}';
    }
}
