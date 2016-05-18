/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegradeNegocio;

/**
 *
 * @author Sanches
 */
public class Produtos {

    private int qtdEstoque;
    private double precoProduto;
    private int idProduto;
    private String tipoDeProduto;

    public void adicionarProduto(String tipoDeProduto, int idProduto, int qtdEstoque, double precoProduto) {

        this.idProduto = idProduto;
        this.tipoDeProduto = tipoDeProduto;
        this.qtdEstoque = qtdEstoque;
        this.precoProduto = precoProduto;

    }

    public void deletarProduto(String idProduto) {

    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipoDeProduto() {
        return tipoDeProduto;
    }

    public void setTipoDeProduto(String tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

}
