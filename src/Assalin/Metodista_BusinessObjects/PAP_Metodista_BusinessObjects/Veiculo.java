package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Veiculo {

    private double capacidade, altura, largura, profundidade;
    private String placa, modelo, descricao;

    public Veiculo(String placa, String modelo, String descricao,
            double capacidade, double altura, double largura, double profundidade) {
        super();
        this.placa = placa;
        this.modelo = modelo;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
