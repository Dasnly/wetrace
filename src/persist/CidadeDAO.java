/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import entity.Cidade;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.TelaCadastroAtividade;

/**
 *
 * @author Victor
 */
public class CidadeDAO {
    
    
        private Connection connection;
     Long id;
     String nome;
     String cpf;
     String email;
     String senha;
     private static String nomeCidade;
     private static String idroteiro;
     
            public void setIdCidade(String string){
           this.idroteiro = string;

        }
         
        public String getIdCidade(){
            return idroteiro;
        }
     
     
      public void setNomeCidade(String string){
           this.nomeCidade = string;

        }
         
        public String getNomeRoteiro(){
            return nomeCidade;
        }


     
     public CidadeDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
     

    
     
     
     public void addCidade(Cidade cidade, String verificacao){ 
 String sql = "INSERT INTO cidade(nome,dataInicio,dataFim,descricao,idroteiro) VALUES(?,?,?,?,?)";
            try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, cidade.getNome());
              stmt.setString(2, cidade.getDataInicio());
              stmt.setString(3, cidade.getDataFim());
              stmt.setString(4, cidade.getDescricao());
              stmt.setString(5, verificacao);
              stmt.execute();
             stmt.close();
          } 
         catch (SQLException u) { 
             throw new RuntimeException(u);
        } 
        
    } 
     
     
     public boolean GetCidadeId(){ 
     String sql = "SELECT idcidade FROM cidade WHERE nome = '" + nomeCidade + "'";

            try {
                
                
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("oi");
                System.out.println(nomeCidade);
                if(rs.first()){ 
                     String a = rs.getString("idcidade");
                     System.out.println(a);
                     TelaCadastroAtividade tca = new TelaCadastroAtividade();
                     tca.setId(a);
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


    

