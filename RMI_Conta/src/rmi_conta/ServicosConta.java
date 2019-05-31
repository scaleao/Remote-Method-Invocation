/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 *
 * @author jscal
 */
public interface ServicosConta extends Remote{
    public Cliente consultarCadastro(String nome) throws RemoteException;
    public void alterarEnredeco(Cliente cliente) throws RemoteException;
    public double consultarSaldo(String nome) throws RemoteException;
    public void realizarVenda(Cliente cliente, Double valor) throws RemoteException;
}
