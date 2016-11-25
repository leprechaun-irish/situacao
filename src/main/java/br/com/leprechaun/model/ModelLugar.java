package br.com.leprechaun.model;

public class ModelLugar {
    
    private int idLugar;
    private ModelCadeira cadeira;
    private ModelFileira fileira;
    private ModelDia dia;
    private ModelSetor setor;

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public ModelCadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(ModelCadeira cadeira) {
        this.cadeira = cadeira;
    }

    public ModelFileira getFileira() {
        return fileira;
    }

    public void setFileira(ModelFileira fileira) {
        this.fileira = fileira;
    }

    public ModelDia getDia() {
        return dia;
    }

    public void setDia(ModelDia dia) {
        this.dia = dia;
    }

    public ModelSetor getSetor() {
        return setor;
    }

    public void setSetor(ModelSetor setor) {
        this.setor = setor;
    }
}
