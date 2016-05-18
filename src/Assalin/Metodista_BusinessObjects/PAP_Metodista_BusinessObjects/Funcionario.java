package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Funcionario extends Pessoa {

    private String cargo;

    public Funcionario(String nome, String cargo, String telefone) {
        super(nome, telefone);
        this.cargo = cargo;

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
