/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jscal
 */
public class Servidor extends UnicastRemoteObject implements ServicosConta{
    ClienteController cc = new ClienteController();
    
    public Servidor() throws RemoteException{
        super();
    }
    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        try{
            Servidor servidor = new Servidor();
            String localizacao = "//localhost/ServicosConta";
            Naming.rebind(localizacao, servidor);
        }
        catch(MalformedURLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        catch(Exception ex){
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public Cliente consultarCadastro(String nome) throws RemoteException {
        Cliente clienteExiste = null;
        try {
            if(clienteExiste==null){
                clienteExiste = cc.consultar(nome);
            }
            else{
                JOptionPane.showMessageDialog(null, "Cliente não existe");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clienteExiste;
    }
    

    @Override
    public void alterarEnredeco(Cliente cliente) throws RemoteException {
        int edicao = 0;
        try {
            edicao = cc.editar(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public double consultarSaldo(String nome) throws RemoteException {
        double valor =0;
        return valor;
    }

    @Override
    public void realizarVenda(Cliente cliente, Double valor) throws RemoteException {
        if (cliente.getSaldo() >= valor){
            Double calculo = cliente.getSaldo() - valor;
            cliente.setSaldo(calculo);
            try {
                cc.pagamento(cliente);
            } catch (SQLException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Transação aceita");
        }
        else{
            JOptionPane.showMessageDialog(null,"Transção recusada, saldo insuficiente");
        }
    }
}
