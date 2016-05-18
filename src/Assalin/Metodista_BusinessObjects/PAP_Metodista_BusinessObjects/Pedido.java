package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

import java.util.ArrayList;

public class Pedido {

    private int codigo;
    private double pesoPedido;
    private String dataEntrega;
    private ArrayList<Caixa> arrayCaixas;
    private Cliente cliente;

    public Pedido(double pesoPedido, String prazoEntrega, ArrayList<Caixa> arrayCaixas, Cliente cliente) {
        super();
        this.pesoPedido = pesoPedido;
        this.dataEntrega = prazoEntrega;
        this.arrayCaixas = arrayCaixas;
        this.cliente = cliente;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPesoPedido(double peso) {
        this.pesoPedido = peso;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setArrayCaixas(ArrayList<Caixa> arrayCaixas) {
        this.arrayCaixas = arrayCaixas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPesoPedido() {
        return pesoPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Caixa> ListarCaixas() {
        arrayCaixas.sort((o1, o2) -> {
            if (o1.getPeso() < o2.getPeso()) {
                return -1;
            }
            if (o1.getPeso() > o2.getPeso()) {
                return 1;
            }
            return 0;
        });
        return arrayCaixas;
    }
}
