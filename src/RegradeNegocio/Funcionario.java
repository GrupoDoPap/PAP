package RegradeNegocio;


/**
 * @version 1.0
 * @created 11-abr-2016 22:14:28
 */
public class Funcionario extends Pessoa {

	private String Cargo;
	private String Data_Admissao;
	private int Id_funcionario;
	private String Setor;

	public Funcionario(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	
	public void Funcionario(String Bairro, String Celular, String Cep, String 
                Cidade, String CPF, String Data_Nascimento, String Email, String 
                        Fixo, String Nome, String Ranking_compra, String RG, String Rua, 
                        String Uf, String Cargo, String Dara_Admissao, int Id_funcionario, String Setor){

	}

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getData_Admissao() {
        return Data_Admissao;
    }

    public void setData_Admissao(String Data_Admissao) {
        this.Data_Admissao = Data_Admissao;
    }

    public int getId_funcionario() {
        return Id_funcionario;
    }

    public void setId_funcionario(int Id_funcionario) {
        this.Id_funcionario = Id_funcionario;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

	

}