/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegradeNegocio;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

/**
 *
 * @author Sanches
 */
public class teste {

    public static void main(String[] args) throws ParseException {
    // obtém o tamanho da tela
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    System.out.println(dim);
    }
}
