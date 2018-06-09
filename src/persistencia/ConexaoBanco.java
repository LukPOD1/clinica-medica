/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lukas
 */
public class ConexaoBanco {
    private static final String banco = "jdbc:mysql://localhost:3306/clinica";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String senha = "";
    private static Connection conexao = null;

    public ConexaoBanco() {

    }

    public static Connection getConexao(){
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection(banco, usuario, senha);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro de SQL:" + ex.getMessage());
            }
            
        }
        return conexao;
        
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        if (conexao == null) {
            conexao = getConexao();
        }
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + ex.getMessage());
        }
        return null;
    }
}
