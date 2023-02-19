package com.CONVERTICSHOP.demo.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_color")
    private Long idColor;
    private String color;

    public Color() {
    }

    public Color(String color, List<Producto> productos) {
        this.color = color;

    }

    public Long getIdColor() {
        return idColor;
    }

    public void setIdColor(Long idColor) {
        this.idColor = idColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Color{" +
                "idColor=" + idColor +
                ", color='" + color + '\'' +
                '}';
    }
}
