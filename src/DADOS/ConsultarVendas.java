package DADOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author greis
 */
public class ConsultarVendas {
    
    ArrayList consultarVendas = new ArrayList();
    
    public void consultarVenda(){
        Connection conn=null;
        
        
        String ConsultaVenda = " SELECT * FROM VENDAS";
           try {
            Conectar C = new Conectar();
            try {
                conn = C.Conectar();

            } catch (Exception e) {
                System.out.println(e);
            }
            
              PreparedStatement sd = conn.prepareStatement(ConsultaVenda);
                ResultSet rs = sd.executeQuery();
                
                while(rs.next()){
                this.consultarVendas.add(rs.getString(1));
                this.consultarVendas.add(rs.getString(2));
                this.consultarVendas.add(rs.getString(3));
                this.consultarVendas.add(rs.getString(4));
                this.consultarVendas.add(rs.getString(5));                
                
                }
          } catch (Exception e) {
            System.out.println("ERRO DE CONEXÃO: " + e);
          }
          
        
               System.out.println(consultarVendas.get(0));
               System.out.println(consultarVendas.get(1));
               System.out.println(consultarVendas.get(2));
               System.out.println(consultarVendas.get(3));
               System.out.println(consultarVendas.get(4));
               
           
           
    } 
    public static void main(String[] args) {
        ConsultarVendas c = new ConsultarVendas();
        c.consultarVenda();
            
    }
    
}
