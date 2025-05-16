package org.teiacoltec.poo.tp1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Turma {
    private int id;
    private String nome;
    private String descricao;
    private Date inicio;
    private Date fim;
    private List<Pessoa> participantes;
    private Turma turmaPai;
    private List<Turma> turmasFilhas;

    public Turma(int id, String nome, String descricao, Date inicio, Date fim) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.participantes = new ArrayList<>();
        this.turmasFilhas = new ArrayList<>();
    }

    public Turma(Turma turmaPai) {
        this(0, "", "", new Date(), new Date());
        this.turmaPai = turmaPai;
        turmaPai.associaSubturma(this); //Para passar o próprio objeto como argumento
    }

    public Pessoa[] obtemListaParticipantes() {
        return participantes.toArray(new Pessoa[0]);
    }

    public void adicionarParticipante(Pessoa p) throws PessoaJaParticipanteException {
        if (participantes.contains(p)) {
            throw new PessoaJaParticipanteException("Pessoa já é participante da turma.");
        }
        participantes.add(p);
    }

    public void removerParticipante(Pessoa p) throws PessoaNaoEncontradaException {
        if (!participantes.contains(p)) {
            throw new PessoaNaoEncontradaException("Pessoa não encontrada na turma.");
        }
        participantes.remove(p);
    }

    public boolean participa(Pessoa p) {
        return participantes.contains(p); //Compara 
    }

    public void associaSubturma(Turma t) {
        turmasFilhas.add(t);
    }



    public void imprimirDetalhes() {
        System.out.println("Turma: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Descrição: " + descricao);
        System.out.println("Início: " + inicio);
        System.out.println("Fim: " + fim);
        System.out.println("Participantes: " + participantes.size());
    }
    
}

