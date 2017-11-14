/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import persist.ViajanteDAO;

/**
 *
 * @author Victor
 */
public class TelaCumprirRoteiro extends javax.swing.JFrame {

    private String idViajante;
    private int maxAtividades;
    private int atividadesFeitas;
    private double gastoTotal;
    private ArrayList<Double> gastoAproximadoList;
    private double gastoAproximadoTotal;

    void setupIdViajante(String idviajante) {
        this.idViajante = idviajante;
        fillTable();
    }

    private void fillTable() {
        System.out.println("filltable");
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/wetrace", "victor", "1234");

            Statement stmt = con.createStatement();
            String SQL = "SELECT cidade.nome, atividade.nome, atividade.tipo, atividade.gastoAproximado, atividade.turno "
                    + "FROM viajante "
                    + "JOIN cidade ON viajante.idroteiro = cidade.idroteiro "
                    + "JOIN atividade ON cidade.idcidade = atividade.idcidade "
                    + "WHERE viajante.idviajante = '" + idViajante + "';";
            ResultSet rs = stmt.executeQuery(SQL);

            initTable(rs);
        } catch (Exception e) {
            System.out.println("CAIU NA EXCEPTION");
        }
    }

    private void initTable(ResultSet rs) {
        System.out.println("initable");
        atividadesFeitas = 0;
        maxAtividades = 0;
        gastoAproximadoList = new ArrayList();
        gastoAproximadoTotal = 0;
        gastoTotal = 0;

        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        try {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(md.getColumnName(i));
            }

            //  Get row data
            while (rs.next()) {
                maxAtividades++;
                Double gasto = (Double) rs.getObject(4);
                gastoAproximadoList.add(gasto);
                gastoAproximadoTotal += gasto;
                ArrayList row = new ArrayList(columns);
                for (int i = 1; i <= columns; i++) {
                    row.add(rs.getObject(i));
                }

                data.add(row);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0;
                i < data.size();
                i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0;
                i < columnNames.size();
                i++) {
            columnNamesVector.add(columnNames.get(i));
        }

        JTable table = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JTextField field = new JTextField();
        getContentPane().add(field, BorderLayout.NORTH);

        JButton bt = new JButton();
        bt.setText("Cumprir Atividade");
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cumprirAtividade(field.getText());
            }
        });
        getContentPane().add(bt, BorderLayout.SOUTH);
    }

    private void cumprirAtividade(String text) {
        if (atividadesFeitas < maxAtividades) {
            try {
                double valor = Double.parseDouble(text);
                createDialog("O valor esperado para realizar atividade era de " + gastoAproximadoList.get(atividadesFeitas) + " e o valor utilizado foi de " + valor);
                gastoTotal += valor;
                atividadesFeitas++;
            } catch (Exception e) {
            }
        } else {
            createDialog("Parabéns, você completou o roteiro!\n "
                    + "O valor total esperado para realizar o roteiro era de " + gastoAproximadoTotal + " e o valor utilizado foi de " + gastoTotal
                    + "\n totalizando uma economia de " + (gastoAproximadoTotal - gastoTotal));
            ViajanteDAO viajDao = new ViajanteDAO();
            viajDao.setRoteiroAtual("-1", idViajante);
            setVisible(false);
        }
    }

    public static void createDialog(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    public TelaCumprirRoteiro() {
        setupIdViajante(TelaLogin.getIdviajante());
        getContentPane().setSize(120, 120);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCumprirRoteiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCumprirRoteiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCumprirRoteiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCumprirRoteiro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCumprirRoteiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
