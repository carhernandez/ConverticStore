package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "envio")
public class Envio {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer idEnvio;

    private LocalDate fecha;

    @ManyToOne(targetEntity = Factura.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura", referencedColumnName = "id_factura")
    Factura factura;

    private String direccion;

    private String telefono;

    public Envio() {
    }

    public Envio(LocalDate fecha, Factura factura, String direccion, String telefono) {
        this.fecha = fecha;
        this.factura = factura;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "idEnvio=" + idEnvio +
                ", fecha=" + fecha +
                ", factura=" + factura +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
