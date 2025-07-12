package org.teiacoltec.poo.tp2.controller;

import org.teiacoltec.poo.tp2.SistemaEscolar;
import java.util.Scanner;

public class MenuController {

    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public void executarMenuPrincipal(SistemaEscolar sistema) {
        int opcao;
        
        do {
            System.out.println("===== Sistema de Notas Escolar =====");
            System.out.println("1. Listar");
            System.out.println("2. Adicionar");
            System.out.println("3. Remover");
            System.out.println("4. Editar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    submenuListar(sistema);
                    break;
                case 2:
                    submenuAdicionar(sistema);
                    break;
                case 3:
                    submenuRemover(sistema);
                    break;
                case 4:
                    submenuEditar(sistema);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void submenuListar(SistemaEscolar sistema) {
        System.out.println("--- Listar ---");
        System.out.println("1. Turmas");
        System.out.println("2. Pessoas");
        System.out.println("3. Atividades");
        System.out.println("4. Tarefas");
        System.out.print("Escolha o que deseja listar: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                sistema.getGerenciadorTurmas().listar();
                break;
            case 2:
                sistema.getGerenciadorPessoas().listar();
                break;
            case 3:
                sistema.getGerenciadorAtividades().listar();
                break;
            case 4:
                sistema.getGerenciadorTarefas().listar();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void submenuAdicionar(SistemaEscolar sistema) {
        System.out.println("--- Adicionar ---");
        System.out.println("1. Turma");
        System.out.println("2. Pessoa");
        System.out.println("3. Atividade");
        System.out.println("4. Tarefa");
        System.out.print("Escolha o que deseja adicionar: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                sistema.getGerenciadorTurmas().adicionar(scanner);
                break;
            case 2:
                sistema.getGerenciadorPessoas().adicionar(scanner);
                break;
            case 3:
                sistema.getGerenciadorAtividades().adicionar(scanner);
                break;
            case 4:
                sistema.getGerenciadorTarefas().adicionar(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void submenuRemover(SistemaEscolar sistema) {
        System.out.println("--- Remover ---");
        System.out.println("1. Turma");
        System.out.println("2. Pessoa");
        System.out.println("3. Atividade");
        System.out.println("4. Tarefa");
        System.out.print("Escolha o que deseja remover: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                sistema.getGerenciadorTurmas().remover(scanner);
                break;
            case 2:
                sistema.getGerenciadorPessoas().remover(scanner);
                break;
            case 3:
                sistema.getGerenciadorAtividades().remover(scanner);
                break;
            case 4:
                sistema.getGerenciadorTarefas().remover(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void submenuEditar(SistemaEscolar sistema) {
        System.out.println("--- Editar ---");
        System.out.println("1. Turma");
        System.out.println("2. Pessoa");
        System.out.println("3. Atividade");
        System.out.println("4. Tarefa");
        System.out.print("Escolha o que deseja editar: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1:
                sistema.getGerenciadorTurmas().editar(scanner);
                break;
            case 2:
                sistema.getGerenciadorPessoas().editar(scanner);
                break;
            case 3:
                sistema.getGerenciadorAtividades().editar(scanner);
                break;
            case 4:
                sistema.getGerenciadorTarefas().editar(scanner);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public void fechar() {
        scanner.close();
    }

} 