package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer idCarrito;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "estado")
    private String estado;
    @ManyToOne(targetEntity = Usuario.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    Usuario usuario;
    @ManyToOne(targetEntity = Producto.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "producto", referencedColumnName = "id_producto")
    Producto producto;
    @Column(name = "cantidad")
    private int cantidad;

    public Carrito() {
    }

    public Carrito(LocalDate fecha, String estado, Usuario usuario, Producto producto, int cantidad) {
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = usuario;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idCarrito=" + idCarrito +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", usuario=" + usuario +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }
}
