/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import factory.ConnectionFactory;
import entity.Viajante;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ViajanteDAO {

    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String senha;
    int level = 1;

    public ViajanteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void addViajante(Viajante viajante) {
        String sql = "INSERT INTO viajante(nome,email,cpf,senha,level) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, viajante.getNome());
            stmt.setString(2, viajante.getCpf());
            stmt.setString(3, viajante.getEmail());
            stmt.setString(4, viajante.getSenha());
            stmt.setInt(5, 1);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void addGuia(Viajante viajante) {
        String sql = "INSERT INTO viajante(nome,email,cpf,senha,level) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, viajante.getNome());
            stmt.setString(2, viajante.getCpf());
            stmt.setString(3, viajante.getEmail());
            stmt.setString(4, viajante.getSenha());
            stmt.setInt(5, 2);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void setRoteiroAtual(String idRoteiro, String idViajante) {
        String sql = "UPDATE viajante SET idroteiro = '" + idRoteiro + "' WHERE idviajante = '" + idViajante + "';";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
}
