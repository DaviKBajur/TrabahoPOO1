package org.teiacoltec.poo.tp2;

import org.teiacoltec.poo.tp2.model.*;
import org.teiacoltec.poo.tp2.controller.MenuController;
import org.teiacoltec.poo.tp2.service.*;

import java.util.*;
import java.io.*;

public class SistemaEscolar {

    private List<Turma> turmas = new ArrayList<>();
    private List<Tarefa> tarefas = new ArrayList<>();
    private List<Atividade> atividades = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    private static final String TURMAS_ARQ = "turmas.ser";
    private static final String TAREFAS_ARQ = "tarefas.ser";
    private static final String ATIVIDADES_ARQ = "atividades.ser";
    private static final String PESSOAS_ARQ = "pessoas.ser";

    private GerenciadorDados gerenciadorDados;
    private MenuController menuController;
    private GerenciadorTurmas gerenciadorTurmas;
    private GerenciadorPessoas gerenciadorPessoas;
    private GerenciadorAtividades gerenciadorAtividades;
    private GerenciadorTarefas gerenciadorTarefas;

    public SistemaEscolar() {
        this.gerenciadorDados = new GerenciadorDados();
        this.menuController = new MenuController();
        this.gerenciadorTurmas = new GerenciadorTurmas(turmas);
        this.gerenciadorPessoas = new GerenciadorPessoas(pessoas);
        this.gerenciadorAtividades = new GerenciadorAtividades(atividades);
        this.gerenciadorTarefas = new GerenciadorTarefas(tarefas, pessoas, turmas, atividades);
    }

    public void iniciar() {
        carregarDados();
        menuController.executarMenuPrincipal(this);
        salvarDados();
    }

    private void carregarDados() {
        try {
            turmas = gerenciadorDados.carregarLista(TURMAS_ARQ);
        } catch (Exception e) {
            turmas = new ArrayList<>();
        }
        
        try {
            tarefas = gerenciadorDados.carregarLista(TAREFAS_ARQ);
        } catch (Exception e) {
            tarefas = new ArrayList<>();
        }
        
        try {
            atividades = gerenciadorDados.carregarLista(ATIVIDADES_ARQ);
        } catch (Exception e) {
            atividades = new ArrayList<>();
        }
        
        try {
            pessoas = gerenciadorDados.carregarLista(PESSOAS_ARQ);
        } catch (Exception e) {
            pessoas = new ArrayList<>();
        }
    }

    private void salvarDados() {
        try {
            gerenciadorDados.salvarLista(turmas, TURMAS_ARQ);
            gerenciadorDados.salvarLista(tarefas, TAREFAS_ARQ);
            gerenciadorDados.salvarLista(atividades, ATIVIDADES_ARQ);
            gerenciadorDados.salvarLista(pessoas, PESSOAS_ARQ);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public GerenciadorTurmas getGerenciadorTurmas() {
        return gerenciadorTurmas;
    }

    public GerenciadorPessoas getGerenciadorPessoas() {
        return gerenciadorPessoas;
    }

    public GerenciadorAtividades getGerenciadorAtividades() {
        return gerenciadorAtividades;
    }

        public GerenciadorTarefas getGerenciadorTarefas() {
        return gerenciadorTarefas;
    }

} 