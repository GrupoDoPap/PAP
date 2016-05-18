package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Caixa {

    private int cod;
    private String nome, descricao;
    private double peso, altura, largura, profundidade;

    public Caixa(int cod, String nome, String descricao, double peso,
            double altura, double largura, double profundidade) {
        super();
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getProfundidade() {
        return profundidade;
    }
}
