/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import entity.Atividade;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class AtividadeDAO {
    
     private Connection connection;
     Long id;
     String nome;
     String cpf;
     String email;
     String senha;
     private static String nomeCidade;
     private static String idcidade;
     
     
        public void setIdCidade(String string){
           this.idcidade = string;

        }
         
        public String getIdCidade(){
            return idcidade;
        }

     
     public AtividadeDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
     

    
     
     
     public void addAtividade(Atividade atividade, String verificacao){ 
 String sql = "INSERT INTO atividade(nome,tipo,gastoAproximado,turno,descricao,idcidade) VALUES(?,?,?,?,?,?)";
            try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, atividade.getNome());
              stmt.setString(2, atividade.getTipo());
              stmt.setString(3, atividade.getGastoAproximado().toString());
              stmt.setString(4, atividade.getTurno());
              stmt.setString(5, atividade.getDescricao());
              stmt.setString(6, verificacao);
              stmt.execute();
             stmt.close();
          } 
         catch (SQLException u) { 
             throw new RuntimeException(u);
        } 
        
    } 

}

    



