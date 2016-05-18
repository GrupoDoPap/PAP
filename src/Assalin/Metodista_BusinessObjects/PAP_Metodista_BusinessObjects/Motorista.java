package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Motorista extends Funcionario {

    private String cnh;

    public Motorista(String cnh, String nome, String cargo, String telefone) {
        super(nome, cargo, telefone);
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
