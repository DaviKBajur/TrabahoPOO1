package org.teiacoltec.poo.tp2;

import org.teiacoltec.poo.tp2.model.*;
import org.teiacoltec.poo.tp2.util.SerializacaoUtil;

import java.util.*;
import java.io.*;

public class Main {
    private static List<Turma> turmas = new ArrayList<>();
    private static List<Tarefa> tarefas = new ArrayList<>();
    private static List<Atividade> atividades = new ArrayList<>();
    private static List<Pessoa> pessoas = new ArrayList<>();

    private static final String TURMAS_ARQ = "turmas.ser";
    private static final String TAREFAS_ARQ = "tarefas.ser";
    private static final String ATIVIDADES_ARQ = "atividades.ser";
    private static final String PESSOAS_ARQ = "pessoas.ser";

    public static void main(String[] args) {
        carregarDados();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("===== Sistema de Notas Escolar =====");
            System.out.println("1. Listar");
            System.out.println("2. Adicionar");
            System.out.println("3. Remover");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    submenuListar(sc);
                    break;
                case 2:
                    submenuAdicionar(sc);
                    break;
                case 3:
                    submenuRemover(sc);
                    break;
                case 4:
                    salvarDados();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
        sc.close();
    }

    private static void carregarDados() {
        try {
            turmas = SerializacaoUtil.carregarLista(TURMAS_ARQ);
        } catch (Exception e) { turmas = new ArrayList<>(); }
        try {
            tarefas = SerializacaoUtil.carregarLista(TAREFAS_ARQ);
        } catch (Exception e) { tarefas = new ArrayList<>(); }
        try {
            atividades = SerializacaoUtil.carregarLista(ATIVIDADES_ARQ);
        } catch (Exception e) { atividades = new ArrayList<>(); }
        try {
            pessoas = SerializacaoUtil.carregarLista(PESSOAS_ARQ);
        } catch (Exception e) { pessoas = new ArrayList<>(); }
    }

    private static void salvarDados() {
        try {
            SerializacaoUtil.salvarLista(turmas, TURMAS_ARQ);
            SerializacaoUtil.salvarLista(tarefas, TAREFAS_ARQ);
            SerializacaoUtil.salvarLista(atividades, ATIVIDADES_ARQ);
            SerializacaoUtil.salvarLista(pessoas, PESSOAS_ARQ);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma t : turmas) {
                System.out.println(t.obterInformacoes());
            }
        }
    }

    private static void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa p : pessoas) {
                System.out.println(p.obterInformacoes());
            }
        }
    }

    private static void listarAtividades() {
        if (atividades.isEmpty()) {
            System.out.println("Nenhuma atividade cadastrada.");
        } else {
            for (Atividade a : atividades) {
                System.out.println(a.obterInformacoes());
            }
        }
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : tarefas) {
                System.out.println(t.obterInformacoes());
            }
        }
    }

    private static void submenuListar(Scanner sc) {
        System.out.println("--- Listar ---");
        System.out.println("1. Turmas");
        System.out.println("2. Pessoas");
        System.out.println("3. Atividades");
        System.out.println("4. Tarefas");
        System.out.print("Escolha o que deseja listar: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1: listarTurmas(); break;
            case 2: listarPessoas(); break;
            case 3: listarAtividades(); break;
            case 4: listarTarefas(); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private static void submenuAdicionar(Scanner sc) {
        System.out.println("--- Adicionar ---");
        System.out.println("1. Turma");
        System.out.println("2. Pessoa");
        System.out.println("3. Atividade");
        System.out.println("4. Tarefa");
        System.out.print("Escolha o que deseja adicionar: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1: adicionarTurma(sc); break;
            case 2: adicionarPessoa(sc); break;
            case 3: adicionarAtividade(sc); break;
            case 4: adicionarTarefa(sc); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private static void submenuRemover(Scanner sc) {
        System.out.println("--- Remover ---");
        System.out.println("1. Turma");
        System.out.println("2. Pessoa");
        System.out.println("3. Atividade");
        System.out.println("4. Tarefa");
        System.out.print("Escolha o que deseja remover: ");
        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1: removerTurma(sc); break;
            case 2: removerPessoa(sc); break;
            case 3: removerAtividade(sc); break;
            case 4: removerTarefa(sc); break;
            default: System.out.println("Opção inválida!");
        }
    }

    // Métodos adicionar/remover (implementação básica)
    private static void adicionarTurma(Scanner sc) {
        System.out.print("Nome da turma: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String desc = sc.nextLine();
        System.out.print("Data início (yyyy-mm-dd): ");
        Date inicio = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Data fim (yyyy-mm-dd): ");
        Date fim = java.sql.Date.valueOf(sc.nextLine());
        Turma turma = new Turma(turmas.size()+1, nome, desc, inicio, fim, null);
        turmas.add(turma);
        System.out.println("Turma adicionada!");
    }
    private static void adicionarPessoa(Scanner sc) {
        System.out.print("Tipo (1-Professor, 2-Aluno, 3-Monitor): ");
        int tipo = sc.nextInt(); sc.nextLine();
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("CPF: "); String cpf = sc.nextLine();
        System.out.print("Nascimento (yyyy-mm-dd): "); Date nasc = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Endereço: "); String end = sc.nextLine();
        Pessoa p = null;
        if (tipo == 1) p = new Professor(cpf, nome, nasc, email, end);
        else if (tipo == 2) p = new Aluno(cpf, nome, nasc, email, end);
        else if (tipo == 3) {
            System.out.print("Matrícula: "); String mat = sc.nextLine();
            System.out.print("Curso: "); String curso = sc.nextLine();
            p = new Monitor(cpf, nome, nasc, email, end, mat, curso);
        }
        if (p != null) {
            pessoas.add(p);
            System.out.println("Pessoa adicionada!");
        } else {
            System.out.println("Tipo inválido!");
        }
    }
    private static void adicionarAtividade(Scanner sc) {
        System.out.print("Nome: "); String nome = sc.nextLine();
        System.out.print("Descrição: "); String desc = sc.nextLine();
        System.out.print("Data início (yyyy-mm-dd): "); Date inicio = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Data fim (yyyy-mm-dd): "); Date fim = java.sql.Date.valueOf(sc.nextLine());
        System.out.print("Valor: "); float valor = sc.nextFloat(); sc.nextLine();
        Atividade a = new Atividade(atividades.size()+1, nome, desc, inicio, fim, valor);
        atividades.add(a);
        System.out.println("Atividade adicionada!");
    }
    private static void adicionarTarefa(Scanner sc) {
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
    private static void removerTurma(Scanner sc) {
        System.out.print("ID da turma: "); int id = sc.nextInt(); sc.nextLine();
        turmas.removeIf(t -> t.getId() == id);
        System.out.println("Turma removida!");
    }
    private static void removerPessoa(Scanner sc) {
        System.out.print("CPF da pessoa: "); String cpf = sc.nextLine();
        pessoas.removeIf(p -> p.getCpf().equals(cpf));
        System.out.println("Pessoa removida!");
    }
    private static void removerAtividade(Scanner sc) {
        System.out.print("ID da atividade: "); int id = sc.nextInt(); sc.nextLine();
        atividades.removeIf(a -> a.getId() == id);
        System.out.println("Atividade removida!");
    }
    private static void removerTarefa(Scanner sc) {
        System.out.print("ID da tarefa: "); int id = sc.nextInt(); sc.nextLine();
        tarefas.removeIf(t -> t.getId() == id);
        System.out.println("Tarefa removida!");
    }
} 