package com.crud.crudbackend.dto;
public class ProductDTO {

    private String nombre;
    private float precio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public ProductDTO() {
    }

    public ProductDTO(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
