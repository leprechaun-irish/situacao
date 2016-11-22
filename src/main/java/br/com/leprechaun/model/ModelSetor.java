package br.com.leprechaun.model;

public class ModelSetor {
    private int idSetor;
    private String descricao;
    private ModelDia dia;
    private double preco;

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ModelDia getDia() {
        return dia;
    }

    public void setDia(ModelDia dia) {
        this.dia = dia;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
