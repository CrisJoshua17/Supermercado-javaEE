/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author crist
 */
public class Product {
    private int codigoBarras;
    private String nombreProducto;
    private double precioProducto;
    private String tipoProducto;
    private int cantidad;
    private List<Product> products;
    
    public Product(int codigoBarras, String nombreProducto, double precioProducto, String tipoProducto, int cantidad) {
        this.codigoBarras = codigoBarras;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.tipoProducto = tipoProducto;
        this.cantidad = cantidad;
    }

    // Getters and setters
    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  
    
    
    
    @Override
    public String toString() {
        return "Product{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}