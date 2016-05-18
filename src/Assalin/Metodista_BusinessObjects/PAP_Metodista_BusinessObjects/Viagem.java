package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

import java.util.ArrayList;
import java.util.Stack;

public class Viagem {

    private int cod;
    private double pesoViagem;
    private String status;
    private Veiculo veiculo;
    private Stack<Pedido> pilhaPedidos;
    private ArrayList<Funcionario> listaAjudantes;
    private Motorista motorista;

    public Viagem(double pesoViagem, String status, Veiculo veiculo,
            Stack<Pedido> pilhaPedidos, ArrayList<Funcionario> listaAjudantes, Motorista motorista) {

        super();
        this.pesoViagem = pesoViagem;
        this.status = status;
        this.veiculo = veiculo;
        this.pilhaPedidos = pilhaPedidos;
        this.listaAjudantes = listaAjudantes;
        this.motorista = motorista;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getPesoViagem() {
        return pesoViagem;
    }

    public void setPesoViagem(double pesoViagem) {
        this.pesoViagem = pesoViagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Stack<Pedido> getPilhaPedidos() {
        return pilhaPedidos;
    }

    public void setPilhaPedidos(Stack<Pedido> pilhaPedidos) {
        this.pilhaPedidos = pilhaPedidos;
    }

    public ArrayList<Funcionario> getListaAjudantes() {
        return listaAjudantes;
    }

    public void setListaAjudantes(ArrayList<Funcionario> listaAjudantes) {
        this.listaAjudantes = listaAjudantes;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
