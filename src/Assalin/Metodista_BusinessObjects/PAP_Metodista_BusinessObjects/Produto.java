package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Produto {

    private int codigo;
    private double preco;
    private String nome, validade;

    public Produto(int codigo, double preco, String nome, String validade) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
        this.validade = validade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
