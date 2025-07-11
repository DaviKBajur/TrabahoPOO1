package org.teiacoltec.poo.tp2.model;

import java.util.Date;

public class Aluno extends Pessoa {
    public Aluno(String cpf, String nome, Date nascimento, String email, String endereco) {
        super(cpf, nome, nascimento, email, endereco);
    }

    @Override
    public String obterInformacoes() {
        return "Aluno: " + getNome() + " | CPF: " + getCpf() + " | Nascimento: " + getNascimento() + " | Email: " + getEmail() + " | Endereço: " + getEndereco();
    }
} 