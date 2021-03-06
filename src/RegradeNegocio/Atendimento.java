package RegradeNegocio;

import java.util.ArrayList;

/**
 * @version 1.0
 * @created 11-abr-2016 22:09:44
 */
public class Atendimento {

    private ArrayList Array_Produtos;
    private String Data_atendimento;
    private int Indentificador_Cliente;
    private double Protocolo_Atendimento;
    private String Tipo_manifesto;
    private String comentario;
    Cliente c = new Cliente();

    public Atendimento() {

    }

    public ArrayList getArray_Produtos() {
        return Array_Produtos;
    }

    public void setArray_Produtos(ArrayList Array_Produtos) {
        this.Array_Produtos = Array_Produtos;
    }

    public String getData_atendimento() {
        return Data_atendimento;
    }

    public void setData_atendimento(String Data_atendimento) {
        this.Data_atendimento = Data_atendimento;
    }

    public int getIndentificador_Cliente() {
        return Indentificador_Cliente;
    }

    public void setIndentificador_Cliente(int Indentificador_Cliente) {
        this.Indentificador_Cliente = Indentificador_Cliente;
    }

    public double getProtocolo_Atendimento() {
        return Protocolo_Atendimento;
    }

    public void setProtocolo_Atendimento(double Protocolo_Atendimento) {
        this.Protocolo_Atendimento = Protocolo_Atendimento;
    }

    public String getTipo_manifesto() {
        return Tipo_manifesto;
    }

    public void setTipo_manifesto(String Tipo_manifesto) {
        this.Tipo_manifesto = Tipo_manifesto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void cadastroAtendimento(Cliente c, String tipoManifesto, String comentario) {

        this.comentario = comentario;
        this.Tipo_manifesto = tipoManifesto;

    }

}
