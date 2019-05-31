/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jscal
 */
public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/rmi";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";
    private static Connection conexao;
    
    public static Connection getConexao(){
        if(conexao == null){
            try {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException ex) {
                System.out.println("Falha ao carregar Driver: "
                        + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("Falha ao conectar ao banco: "
                        + ex.getMessage());
            }
        }
        return conexao;
    }
}
