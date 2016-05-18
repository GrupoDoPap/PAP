/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegradeNegocio;

/**
 *
 * @author Sanches
 */
public class teste {

    public static void main(String[] args) {
        Atendimento a = new Atendimento();
        Produtos p = new Produtos();
        Login l = new Login();
        a.cadastroCliente("Daniel", "405.990.188.10", "sanches_dado@hotmail.com", "968738481",
                "4437-2412", "483510336", "São Bernardo", "Rua Tiradentes", "sta Terezinha",
                "bloco 11 apto 155", "09781220", "SP");

        System.out.println(a);

        String[] teste = new String[4];
        int i = 0;
        p.adicionarProduto("suplemento", 12345, 10, 1000);
        System.out.println(p.getTipoDeProduto());
        System.out.println(p.getIdProduto());
        System.out.println(p.getQtdEstoque());
        System.out.println(p.getPrecoProduto());

        l.login("12345", "12345");
        l.login("1234", "1234");
        
        
        
    }
}
