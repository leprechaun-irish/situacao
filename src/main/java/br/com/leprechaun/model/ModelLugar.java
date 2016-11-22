package br.com.leprechaun.model;

public class ModelLugar {
    
    private int idLugar;
    private int cadeira;
    private ModelFileira fileira;
    private ModelDia dia;

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
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
}
