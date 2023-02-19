package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Column(name = "fecha")
    private LocalDate fecha;
    @ManyToOne(targetEntity = Carrito.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrito", referencedColumnName = "id_carrito")
    Carrito carrito;
    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    Usuario usuario;
    @Column(name = "iva")
    private Float iva;
    @Column(name = "total")
    private Float total;

    public Factura() {
    }

    public Factura(LocalDate fecha, Carrito carrito, Usuario usuario, Float iva, Float total) {
        this.fecha = fecha;
        this.carrito = carrito;
        this.usuario = usuario;
        this.iva = iva;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}

