/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_conta;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author jscal
 */
public class Cliente implements Serializable{
    protected String id;
    protected String nome;
    protected String senha;
    protected String endereco;
    protected Double saldo;
    
    public Cliente(){
    
    }

    public Cliente (String id, String nome, String senha, String endereco, Double saldo){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.saldo = saldo;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public String toString(){
        return new StringBuffer(" id: ")
        .append(this.id)
        .append(" nome: ")
        .append(this.nome)
        .append(" senha: ")
        .append(this.senha)
        .append(" endereco: ")
        .append(this.endereco)
        .append(" saldo: ")
        .append(this.saldo).toString();
    }
}