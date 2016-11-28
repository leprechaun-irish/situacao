package br.com.leprechaun.model;

import java.sql.Timestamp;

public class ModelIngresso {
    private int idIngresso;
    private ModelCliente cliente;
    private ModelLugar lugar;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    private Timestamp data;

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public ModelCliente getCliente() {
        return cliente;
    }

    public void setCliente(ModelCliente cliente) {
        this.cliente = cliente;
    }

    public ModelLugar getLugar() {
        return lugar;
    }

    public void setLugar(ModelLugar lugar) {
        this.lugar = lugar;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
}
