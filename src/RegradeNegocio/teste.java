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

       a.cadastroCliente("Daniel", "405.990.188.10", "sanches_dado@hotmail.com", "968738481",
                "4437-2412", "483510336", "São Bernardo", "Rua Tiradentes", "sta Terezinha",
                "bloco 11 apto 155", "09781220", "SP");
        
        System.out.print(a);

    }
}
