/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author jscal
 */
public class ClienteController {
    private final Connection conexao;
    private final String QUERY_INSERT_CLIENTE =
            "INSERT INTO cliente"
            + "(id, nome, senha, endereco, saldo)"
            + " VALUES (?,?,?,?,?)";;
    private final String QUERY_CONSULTAR =
            "SELECT * FROM cliente WHERE nome = ?";
    private final String QUERY_EDITAR =
            "UPDATE cliente SET id = ?, nome = ?, senha = ?, endereco = ?, saldo = ? WHERE id = ?";
    private final String QUERY_PAGAMENTO =
            "UPDATE cliente SET saldo = ? WHERE id = ?";
    public ClienteController(){
        conexao = Conexao.getConexao();
    }
    
    
    public int inserir(Cliente cliente) throws SQLException, PSQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_INSERT_CLIENTE);
        ps.setString(1, cliente.getId());
        ps.setString(2, cliente.getNome());
        ps.setString(3, cliente.getSenha());
        ps.setString(4, cliente.getEndereco());
        ps.setDouble(5, cliente.getSaldo());
        return ps.executeUpdate();
    }
    
    public Cliente consultar(String nome) throws SQLException{
        Cliente temp = null;
        PreparedStatement ps = conexao.prepareStatement(QUERY_CONSULTAR);
        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            temp = new Cliente();
            temp.setId(rs.getString("id"));
            temp.setNome(rs.getString("nome"));
            temp.setSenha(rs.getString("senha"));
            temp.setEndereco(rs.getString("endereco"));
            temp.setSaldo(rs.getDouble("saldo"));
        }
        return temp;
    }
    
    public int editar(Cliente cliente) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_EDITAR);
        ps.setString(1, cliente.getId());
        ps.setString(2, cliente.getNome());
        ps.setString(3, cliente.getSenha());
        ps.setString(4, cliente.getEndereco());
        ps.setDouble(5, cliente.getSaldo());
        ps.setString(6, cliente.getId());
        return ps.executeUpdate();
    }
    
    public int pagamento(Cliente cliente) throws SQLException{
        PreparedStatement ps = conexao.prepareStatement(QUERY_PAGAMENTO);
        ps.setDouble(1, cliente.getSaldo());
        ps.setString(2, cliente.getId());
        return ps.executeUpdate();
    }
}
