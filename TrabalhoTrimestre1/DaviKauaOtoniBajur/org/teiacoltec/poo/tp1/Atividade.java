package org.teiacoltec.poo.tp1;

import java.util.Date;

public class Atividade {
    private int id;
    private String nome;
    private String descricao;
    private Date inicio;
    private Date fim;

    public Atividade(int id, String nome, String descricao, Date inicio, Date fim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
    }


    public void imprimirDetalhes() {
        System.out.println("Atividade: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Início: " + inicio);
        System.out.println("Fim: " + fim);
    }

    
    
}