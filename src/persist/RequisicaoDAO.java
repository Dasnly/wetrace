/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import entity.Requisicao;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class RequisicaoDAO {
    
     private Connection connection;
     Long id;
     String nome;
     String cpf;
     String email;
     String senha;
     private static String nomeRoteiro;
     private static String idroteiro;


     
     public RequisicaoDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
     

    
     
     
     public void addRequisicao(Requisicao requisicao){ 
 String sql = "INSERT INTO requisicao (regiao,dataInicio,oqueEspero) VALUES(?,?,?)";
            try { 
                PreparedStatement stmt = connection.prepareStatement(sql);
              stmt.setString(1, requisicao.getRegiao());
              stmt.setString(2, requisicao.getDataInicio());
              stmt.setString(3, requisicao.getOqueEspero());
              stmt.execute();
             stmt.close();
          } 
         catch (SQLException u) { 
             throw new RuntimeException(u);
        } 
        
    } 
    
}
