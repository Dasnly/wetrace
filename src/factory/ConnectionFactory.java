/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection; 

import java.sql.DriverManager; 
import java.sql.ResultSet;

import java.sql.SQLException; 
import java.sql.Statement;

public class ConnectionFactory {  
    
  public  Connection con;
  public  Statement stmt;
  public  ResultSet rs;
  
  String url = "jdbc:mysql://localhost/wetrace";
  String driver = "com.mysql.jdbc.Driver";
  String user = "victor";
  String password = "1234";
  
  
  public void abrirConexao(){
      try {
          Class.forName(driver).newInstance();
      con = DriverManager.getConnection(url, user, password);
              
              stmt = con.createStatement();
              
      } catch (Exception e) {
      }
      
      
  }
    



    public Connection getConnection() {
		 try {
			return DriverManager.getConnection("jdbc:mysql://localhost/wetrace","victor","1234");
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
}
     
