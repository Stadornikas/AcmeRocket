/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class Conexao {

    private static java.sql.Connection connection;
    private static String url = "jdbc:mysql://acmerocket.mysql.dbaas.com.br:3306/acmerocket";
    private static String usuario = "acmerocket";
    private static String senha = "Acme@2016";
    
    public static java.sql.Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexão\n" + e);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o banco de dados\n" + e);
            }
        }
        return connection;
    }

}
