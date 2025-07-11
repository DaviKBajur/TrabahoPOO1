package org.teiacoltec.poo.tp2.model;

import java.util.Date;

public class Professor extends Pessoa {
    public Professor(String cpf, String nome, Date nascimento, String email, String endereco) {
        super(cpf, nome, nascimento, email, endereco);
    }

    @Override
    public String obterInformacoes() {
        return "Professor: " + getNome() + " | CPF: " + getCpf() + " | Nascimento: " + getNascimento() + " | Email: " + getEmail() + " | Endereço: " + getEndereco();
    }
} 