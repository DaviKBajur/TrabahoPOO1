package org.teiacoltec.poo.tp1;

import java.util.Date;

public class Aluno extends Pessoa {
    private String Matricula;
    private String Curso;

    public Aluno(String cpf, String nome, Date nascimento, String email, String endereco,
                     String Matricula, String Curso) {
        super(cpf, nome, nascimento, email, endereco);
        this.Matricula = Matricula;
        this.Curso = Curso;
    }

    public String getMatricula() { 
        return Matricula; 
    }
    public void setMatricula(String Matricula) { 
        this.Matricula = Matricula; 
    }

    public String getCurso() { 
        return Curso; 
    }
    public void setCurso(String Curso) { 
        this.Curso = Curso; 
    }

    public String obterInformacoes() {
    return super.obterInformacoes() + "\nMatrícula: " + Matricula + "\nCurso: " + Curso;
    }
}