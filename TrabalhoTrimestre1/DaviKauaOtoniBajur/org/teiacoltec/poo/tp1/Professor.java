package org.teiacoltec.poo.tp1;

import java.util.Date;

public class Professor extends Pessoa {
    private String matricula;
    private String formacao;

    public Professor(String cpf, String nome, Date nascimento, String email, String endereco,
                     String matricula, String formacao) {
        super(cpf, nome, nascimento, email, endereco);
        this.matricula = matricula;
        this.formacao = formacao;
    }

    public String getMatricula() { 
        return matricula; 
    }
    public void setMatricula(String matricula) { 
        this.matricula = matricula; 
    }

    public String getFormacao() { 
        return formacao; 
    }
    public void setFormacao(String formacao) { 
        this.formacao = formacao; 
    }

    public String obterInformacoes() {
    return super.obterInformacoes() + "\nMatrícula: " + matricula + "\nFormação: " + formacao;
    }
}