package RegradeNegocio;

/**
 * @version 1.0
 * @created 11-abr-2016 22:12:13
 */
public class Pessoa {

    private String Bairro;
    private String Celular;
    private String Cep;
    private int numero;
    private String Cidade;
    private String CPFCNPJ;
    private String Data_Nascimento;
    private String Email;
    private String Fixo;
    private String Nome;
    private String Ranking_compra;
    private String RG;
    private String Rua;
    private String Uf;
    private String Complemento;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoa(String bairro, String celular, String cep, String cidade, String cpfcnpj, String dtNascimento, String email, String fixo, String nome, String rg, String rua, String uf, String complemento) {
        this.Bairro = bairro;
        this.Celular = celular;
        this.Cep = cep;
        this.Cidade = cidade;
        this.CPFCNPJ = cpfcnpj;
        this.Data_Nascimento = dtNascimento;
        this.Email = email;
        this.Fixo = fixo;
        this.Nome = nome;
        this.RG = rg;
        this.Rua = rua;
        this.Uf = uf;
        this.Complemento = complemento;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    public void setCPFCNPJ(String CPF) {
        this.CPFCNPJ = CPF;
    }

    public String getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(String Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFixo() {
        return Fixo;
    }

    public void setFixo(String Fixo) {
        this.Fixo = Fixo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRanking_compra() {
        return Ranking_compra;
    }

    public void setRanking_compra(String Ranking_compra) {
        this.Ranking_compra = Ranking_compra;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String Uf) {
        this.Uf = Uf;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public Pessoa() {

    }

}
