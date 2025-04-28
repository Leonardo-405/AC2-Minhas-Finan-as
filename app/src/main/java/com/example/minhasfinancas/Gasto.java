package com.example.minhasfinancas;

public class Gasto {

    private String descricao;
    private String valor;
    private String categoria;
    private String data;

    public Gasto(String descricao, String valor, String categoria, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "descricao='" + descricao + '\'' +
                ", valor='" + valor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
