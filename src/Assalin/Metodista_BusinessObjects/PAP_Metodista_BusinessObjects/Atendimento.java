package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

import java.util.ArrayList;

public class Atendimento {

    private int numero;
    private String dataInicio, dataFim, satisfacao, status, motivo, descricao;
    private Cliente cliente;
    private ArrayList<Produto> arrayProdutos;

    public Atendimento(int numero, String dataInicio, String dataFim,
            String satisfacao, String status, String motivo, String descricao,
            Cliente cliente, ArrayList<Produto> arrayProdutos) {
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.satisfacao = satisfacao;
        this.status = status;
        this.motivo = motivo;
        this.descricao = descricao;
        this.cliente = cliente;
        this.arrayProdutos = arrayProdutos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getSatisfacao() {
        return satisfacao;
    }

    public void setSatisfacao(String satisfacao) {
        this.satisfacao = satisfacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getArrayProdutos() {
        return arrayProdutos;
    }

    public void setArrayProdutos(ArrayList<Produto> arrayProdutos) {
        this.arrayProdutos = arrayProdutos;
    }

}
