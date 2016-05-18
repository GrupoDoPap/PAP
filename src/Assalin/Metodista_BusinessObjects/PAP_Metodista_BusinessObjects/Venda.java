package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Venda {

    private int codigo;
    private String data;
    private double valorFinal, desconto;
    private Produto produto;
    private Cliente cliente;

    public Venda(int codigo, String data, double valorFinal, double desconto,
            Produto produto, Cliente cliente) {
        this.codigo = codigo;
        this.data = data;
        this.valorFinal = valorFinal;
        this.desconto = desconto;
        this.produto = produto;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
