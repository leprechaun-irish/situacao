package br.com.leprechaun.model;

public class ModelSD {
    private int idSD;
    private double preco;
    private ModelSetor setor;
    private ModelDia dia;

    public int getIdSD() {
        return idSD;
    }

    public void setIdSD(int idSD) {
        this.idSD = idSD;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ModelSetor getSetor() {
        return setor;
    }

    public void setSetor(ModelSetor setor) {
        this.setor = setor;
    }

    public ModelDia getDia() {
        return dia;
    }

    public void setDia(ModelDia dia) {
        this.dia = dia;
    }
}
