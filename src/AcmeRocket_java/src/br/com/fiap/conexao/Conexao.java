package br.com.fiap.conexao;

import config.Propriedades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexao {

    private static Properties prop =  Propriedades.getProp();
    
    private static Connection connection;
    private static String url = prop.getProperty("prop.database.Driver");
    private static String usuario = prop.getProperty("prop.database.User");
    private static String senha = prop.getProperty("prop.database.Pass");
//    private static String url = "jdbc:mysql://acmerocket.mysql.dbaas.com.br:3306/acmerocket";;
//    private static String usuario = "acmerocket";
//    private static String senha = "Acme@2016";
    
   

    public static Connection getConnection() {
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
