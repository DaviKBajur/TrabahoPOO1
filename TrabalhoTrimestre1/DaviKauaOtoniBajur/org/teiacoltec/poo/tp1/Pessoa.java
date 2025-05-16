package org.teiacoltec.poo.tp1;

import java.util.Date;

public class Pessoa {
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

    public String getcpf() { 
        return cpf; 
    }
    public void setcpf(String cpf) { 
        this.cpf = cpf; 
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() { 
        return nascimento; 
    }
    public void setNascimento(Date nascimento) { 
        this.nascimento = nascimento; 
    }

    public String getEmail() { 
        return email; 
        }
    public void setEmail(String email) { 
        this.email = email; 
        }

    public String getEndereco() { 
        return endereco; 
        }
    public void setEndereco(String endereco) { 
        this.endereco = endereco; 
            }

    public String obterInformacoes() {
        return "Nome: " + nome + "\ncpf: " + cpf + "\nNascimento: " + nascimento +
            "\nEmail: " + email + "\nEndereço: " + endereco;
    }
}