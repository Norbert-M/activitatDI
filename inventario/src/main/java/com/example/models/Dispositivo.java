package com.example.models;

import java.time.LocalDate;

public class Dispositivo {
    public enum TipoAtributo {
        ORDENADOR, PANTALLA, IMPRESORA, PROYECTOR, PORTATIL, ROUTER
    }
    
    private int id;
    private LocalDate fechaCompra;
    private double precio;
    private TipoAtributo tipo;
    private String marca;
    private String modelo;

    public Dispositivo(int id, LocalDate fechaCompra, double precio, TipoAtributo tipo, String marca, String modelo) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.precio = precio;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoAtributo getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtributo tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", fechaCompra=" + fechaCompra +
                ", precio=" + precio +
                ", tipo=" + tipo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }


    public void altaDispositivo(int id, LocalDate fechaCompra, double precio, TipoAtributo tipo, String marca, String modelo){
        Dispositivo dispositivoNuevo = new Dispositivo(id, fechaCompra, precio, tipo, marca, modelo);

        //Añadir dispositivo a la lista de dispositivos

        
        
    }


    


    
}
