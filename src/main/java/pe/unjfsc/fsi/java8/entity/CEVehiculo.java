/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.unjfsc.fsi.java8.entity;

import java.util.Objects;

/**
 *
 * @author Hugo Grados
 */
public class CEVehiculo{
    private int idVehiculo;
    private String placa;
    private String nroSerie;
    private int marca;
    private int color;
    private int tipoCarga;
    private int nroLlantas;
    private double peso_bruto;
    private double peso_neto;
    private double peso_util;

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public int getNroLlantas() {
        return nroLlantas;
    }

    public void setNroLlantas(int nroLlantas) {
        this.nroLlantas = nroLlantas;
    }

    public double getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(double peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public double getPeso_neto() {
        return peso_neto;
    }

    public void setPeso_neto(double peso_neto) {
        this.peso_neto = peso_neto;
    }

    public double getPeso_util() {
        return peso_util;
    }

    public void setPeso_util(double peso_util) {
        this.peso_util = peso_util;
    }

    
    
}