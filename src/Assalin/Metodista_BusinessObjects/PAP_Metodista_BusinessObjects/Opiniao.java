package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Opiniao {

    private int codigo;
    private String descricao, fonte, classificacao, data;
    private Cliente cliente;

    public Opiniao(int codigo, String descricao, String fonte, String classificacao, String data, Cliente cliente) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.fonte = fonte;
        this.classificacao = classificacao;
        this.data = data;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
