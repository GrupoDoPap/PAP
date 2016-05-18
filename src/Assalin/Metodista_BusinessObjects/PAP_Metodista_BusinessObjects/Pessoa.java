package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Pessoa {

    private int codigo;
    private String nome, telefone;

    public Pessoa(String nome, String telefone) {
        super();
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
