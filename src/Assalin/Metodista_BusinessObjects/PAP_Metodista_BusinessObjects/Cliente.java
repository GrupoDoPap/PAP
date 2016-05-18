package Metodista_BusinessObjects.PAP_Metodista_BusinessObjects;

public class Cliente extends Pessoa {

    private String email, cpf_cnpj, cep, rua, bairro, cidade, uf, classificacao, celular;
    private double distanciaFilial;

    public Cliente(String email, String cpf_cnpj, String cep, String rua,
            String bairro, String cidade, String uf, String classificacao,
            double distanciaFilial, String nome, String telefone, String celular) {
        super(nome, telefone);
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.classificacao = classificacao;
        this.distanciaFilial = distanciaFilial;
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public double getDistanciaFilial() {
        return distanciaFilial;
    }

    public void setDistanciaFilial(double distanciaFilial) {
        this.distanciaFilial = distanciaFilial;
    }

}
