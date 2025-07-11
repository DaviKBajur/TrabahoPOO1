package org.teiacoltec.poo.tp2.model;

import java.io.Serializable;

public class Tarefa implements Serializable {
    private int id;
    private Aluno aluno;
    private Turma turma;
    private Atividade atividade;
    private float nota;

    public Tarefa(int id, Aluno aluno, Turma turma, Atividade atividade, float nota) {
        this.id = id;
        this.aluno = aluno;
        this.turma = turma;
        this.atividade = atividade;
        this.nota = nota;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Turma getTurma() { return turma; }
    public void setTurma(Turma turma) { this.turma = turma; }
    public Atividade getAtividade() { return atividade; }
    public void setAtividade(Atividade atividade) { this.atividade = atividade; }
    public float getNota() { return nota; }
    public void setNota(float nota) { this.nota = nota; }

    public String obterInformacoes() {
        return "Tarefa: " + id + " | Aluno: " + aluno.getNome() + " | Turma: " + turma.getNome() + " | Atividade: " + atividade.getNome() + " | Nota: " + nota;
    }

    public static Tarefa obtemTarefaPorID(int id, java.util.List<Tarefa> tarefas) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public static Tarefa[] obtemTarefasDaPessoa(Pessoa pessoa, java.util.List<Tarefa> tarefas) {
        java.util.List<Tarefa> lista = new java.util.ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getAluno().equals(pessoa)) {
                lista.add(t);
            }
        }
        return lista.toArray(new Tarefa[0]);
    }

    public static Tarefa[] obtemTarefasDaPessoa(Pessoa pessoa, java.util.Date inicio, java.util.Date fim, java.util.List<Tarefa> tarefas) {
        java.util.List<Tarefa> lista = new java.util.ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.getAluno().equals(pessoa)) {
                java.util.Date dataAtividade = t.getAtividade().getInicio();
                if (!dataAtividade.before(inicio) && !dataAtividade.after(fim)) {
                    lista.add(t);
                }
            }
        }
        return lista.toArray(new Tarefa[0]);
    }
} 