package org.teiacoltec.poo.tp2.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Professor extends Pessoa {
    public Professor(String cpf, String nome, Date nascimento, String email, String endereco) {
        super(cpf, nome, nascimento, email, endereco);
    }

    @Override
    public String obterInformacoes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "Professor: " + getNome() + " | CPF: " + getCpf() + " | Nascimento: " + sdf.format(getNascimento()) + " | Email: " + getEmail() + " | Endereço: " + getEndereco();
    }
} 