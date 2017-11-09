/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import entity.Roteiro;
import entity.Viajante;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.TelaCadastroCidade;
import view.TelaLogin;


/**
 *
 * @author Victor
 */
public class RoteiroDAO {
    
    private Connection connection;
     Long id;
     String nome;
     String cpf;
     String email;
     String senha;
     private static String nomeRoteiro;
     private static String idroteiro;
     
     
       public void setIdRoteiro(String string){
           this.idroteiro = string;

        }
         
        public String getIdRoteiro(){
            return idroteiro;
        }
     
     
      public void setNomeRoteiro(String string){
           this.nomeRoteiro = string;

        }
         
        public String getNomeRoteiro(){
            return nomeRoteiro;
        }


     
     public RoteiroDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
     

    
     
     
     public void addRoteiro(Roteiro roteiro, String verificacao){ 
 String sql = "INSERT INTO roteiro(nome,regiao,dataInicio,descricao,idviajante) VALUES(?,?,?,?,?)";
            try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, roteiro.getNome());
              stmt.setString(2, roteiro.getRegiao());
              stmt.setString(3, roteiro.getDataInicio());
              stmt.setString(4, roteiro.getDescricao());
                System.out.println(verificacao);
              stmt.setString(5,verificacao);
              
              stmt.execute();
             stmt.close();
          } 
         catch (SQLException u) { 
             throw new RuntimeException(u);
        } 
        
    } 
     

     
     
     public boolean GetRoteiroId(){ 
     String sql = "SELECT idroteiro FROM roteiro WHERE nome = '" + nomeRoteiro + "'";

            try {
                
                
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("oi");
                System.out.println(nomeRoteiro);
                if(rs.first()){ 
                     String a = rs.getString("idroteiro");
                     System.out.println(a);
                     TelaCadastroCidade tcc = new TelaCadastroCidade();
                     tcc.setId(a);
                     idroteiro = a;
                         return true;
                }
          } 
         catch (SQLException u) { 
             throw new RuntimeException(u);
        } 
        return false;
    } 
}
