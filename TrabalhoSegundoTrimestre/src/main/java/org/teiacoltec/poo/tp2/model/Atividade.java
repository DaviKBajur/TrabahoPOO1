package org.teiacoltec.poo.tp2.model;

import java.io.Serializable;
import java.util.Date;

public class Atividade implements Serializable {
    private int id;
    private String nome;
    private String descricao;
    private Date inicio;
    private Date fim;
    private float valor;

    public Atividade(int id, String nome, String descricao, Date inicio, Date fim, float valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Date getInicio() { return inicio; }
    public void setInicio(Date inicio) { this.inicio = inicio; }
    public Date getFim() { return fim; }
    public void setFim(Date fim) { this.fim = fim; }
    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }

    public String obterInformacoes() {
        return "Atividade: " + nome + " | ID: " + id + " | Descrição: " + descricao + " | Início: " + inicio + " | Fim: " + fim + " | Valor: " + valor;
    }

    public static Atividade obtemAtividadePorID(int id, java.util.List<Atividade> atividades) {
        for (Atividade a : atividades) {
            if (a.getId() == id) return a;
        }
        return null;
    }
} 