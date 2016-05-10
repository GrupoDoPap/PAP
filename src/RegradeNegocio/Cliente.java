package RegradeNegocio;

/**
 * @version 1.0
 * @created 11-abr-2016 22:11:40
 */
public class Cliente extends Pessoa {

    private String Data_cadastro;
    private String Data_compra;
    private int Id_manifesto;
    private int Id_produto;
    private String Manifesto;
    private String Produto_comprado;

    public String getData_cadastro() {
        return Data_cadastro;
    }

    public void setData_cadastro(String Data_cadastro) {
        this.Data_cadastro = Data_cadastro;
    }

    public String getData_compra() {
        return Data_compra;
    }

    public void setData_compra(String Data_compra) {
        this.Data_compra = Data_compra;
    }

    public int getId_manifesto() {
        return Id_manifesto;
    }

    public void setId_manifesto(int Id_manifesto) {
        this.Id_manifesto = Id_manifesto;
    }

    public int getId_produto() {
        return Id_produto;
    }

    public void setId_produto(int Id_produto) {
        this.Id_produto = Id_produto;
    }

    public String getManifesto() {
        return Manifesto;
    }

    public void setManifesto(String Manifesto) {
        this.Manifesto = Manifesto;
    }

    public String getProduto_comprado() {
        return Produto_comprado;
    }

    public void setProduto_comprado(String Produto_comprado) {
        this.Produto_comprado = Produto_comprado;
    }

    public Cliente() {

    }

   
}
