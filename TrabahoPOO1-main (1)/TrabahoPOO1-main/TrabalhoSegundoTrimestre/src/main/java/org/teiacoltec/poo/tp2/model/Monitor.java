package org.teiacoltec.poo.tp2.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Monitor extends Pessoa {
    private String matricula;
    private String curso;

    public Monitor(String cpf, String nome, Date nascimento, String email, String endereco, String matricula, String curso) {
        super(cpf, nome, nascimento, email, endereco);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    @Override
    public String obterInformacoes() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "Monitor: " + getNome() + " | CPF: " + getCpf() + " | Nascimento: " + sdf.format(getNascimento()) + " | Email: " + getEmail() + " | Endereço: " + getEndereco() + " | Matrícula: " + matricula + " | Curso: " + curso;
    }
} 