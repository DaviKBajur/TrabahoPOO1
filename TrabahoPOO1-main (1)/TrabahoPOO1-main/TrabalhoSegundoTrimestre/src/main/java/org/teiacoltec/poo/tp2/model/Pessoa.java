/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.teiacoltec.poo.tp2.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa implements Serializable {
    private String cpf;
    private String nome;
    private Date nascimento;
    private String email;
    private String endereco;

    public Pessoa(String cpf, String nome, Date nascimento, String email, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.endereco = endereco;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Date getNascimento() { return nascimento; }
    public void setNascimento(Date nascimento) { this.nascimento = nascimento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public abstract String obterInformacoes();
}
