package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;
    private String descripcion;

    @ManyToOne(targetEntity = Marca.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "marca", referencedColumnName = "id_marca")
    private String marca;

    @ManyToOne(targetEntity = Color.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "color", referencedColumnName = "id_color")
    private Color color;
    @ManyToOne(targetEntity = Genero.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero", referencedColumnName = "id_genero")
    private Genero genero;
    @ManyToOne(targetEntity = Talla.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "talla", referencedColumnName = "id_talla")
    private Talla talla;
    private Integer valor;
    private Integer cantidad;

    public Producto() {
    }

    public Producto(String descripcion, String marca, Color color, Genero genero, Talla talla, Integer valor, Integer cantidad) {
        this.descripcion = descripcion;
        this.marca = marca;
        this.color = color;
        this.genero = genero;
        this.talla = talla;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}




