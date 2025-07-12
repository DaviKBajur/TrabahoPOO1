package org.teiacoltec.poo.tp2.service;

import org.teiacoltec.poo.tp2.model.*;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas;
    private List<Pessoa> pessoas;
    private List<Turma> turmas;
    private List<Atividade> atividades;
    
    public GerenciadorTarefas(List<Tarefa> tarefas, List<Pessoa> pessoas, List<Turma> turmas, List<Atividade> atividades) {
        this.tarefas = tarefas;
        this.pessoas = pessoas;
        this.turmas = turmas;
        this.atividades = atividades;
    }
    
    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : tarefas) {
                System.out.println(t.obterInformacoes());
            }
        }
    }
    
    public void adicionar(Scanner sc) {
        System.out.print("ID do aluno: "); int idAluno = sc.nextInt(); sc.nextLine();
        System.out.print("ID da turma: "); int idTurma = sc.nextInt(); sc.nextLine();
        System.out.print("ID da atividade: "); int idAtiv = sc.nextInt(); sc.nextLine();
        System.out.print("Nota: "); float nota = sc.nextFloat(); sc.nextLine();
        Aluno aluno = null;
        Turma turma = null;
        Atividade ativ = null;
        for (Pessoa p : pessoas) if (p instanceof Aluno && ((Aluno)p).getCpf().equals(String.valueOf(idAluno))) aluno = (Aluno)p;
        for (Turma t : turmas) if (t.getId() == idTurma) turma = t;
        for (Atividade a : atividades) if (a.getId() == idAtiv) ativ = a;
        if (aluno != null && turma != null && ativ != null) {
            Tarefa t = new Tarefa(tarefas.size()+1, aluno, turma, ativ, nota);
            tarefas.add(t);
            System.out.println("Tarefa adicionada!");
        } else {
            System.out.println("Dados inválidos!");
        }
    }
    
    public void remover(Scanner sc) {
        System.out.print("ID da tarefa: ");
        int id = sc.nextInt();
        sc.nextLine();
        tarefas.removeIf(t -> t.getId() == id);
        System.out.println("Tarefa removida!");
    }
    
    public void editar(Scanner sc) {
        System.out.print("ID da tarefa a editar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        Tarefa tarefa = null;
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                tarefa = t;
                break;
            }
        }
        
        if (tarefa == null) {
            System.out.println("Tarefa não encontrada!");
            return;
        }
        
        System.out.println("Tarefa encontrada: " + tarefa.obterInformacoes());
        System.out.println("Deixe em branco para manter o valor atual");
        
        System.out.print("Nova nota: ");
        String notaStr = sc.nextLine();
        if (!notaStr.trim().isEmpty()) {
            try {
                float nota = Float.parseFloat(notaStr);
                tarefa.setNota(nota);
                System.out.println("Nota editada com sucesso!");
            } catch (NumberFormatException e) {
                System.out.println("Nota inválida! Mantendo nota atual.");
            }
        } else {
            System.out.println("Nenhuma alteração realizada.");
        }
    }
} 