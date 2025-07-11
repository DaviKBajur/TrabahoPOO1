package org.teiacoltec.poo.tp2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.teiacoltec.poo.tp2.exception.PessoaJaParticipanteException;
import org.teiacoltec.poo.tp2.exception.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp2.exception.AtividadeJaAssociadaATurmaException;
import org.teiacoltec.poo.tp2.exception.AtividadeNaoAssociadaATurmaException;

public class Turma implements Serializable {
    private int id;
    private String nome;
    private String descricao;
    private Date inicio;
    private Date fim;
    private List<Pessoa> participantes;
    private Turma turmaPai;
    private List<Turma> turmasFilhas;
    private List<Atividade> atividades;

    public Turma(int id, String nome, String descricao, Date inicio, Date fim, Turma turmaPai) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.turmaPai = turmaPai;
        this.participantes = new ArrayList<>();
        this.turmasFilhas = new ArrayList<>();
        this.atividades = new ArrayList<>();
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
    public List<Pessoa> getParticipantes() { return participantes; }
    public Turma getTurmaPai() { return turmaPai; }
    public void setTurmaPai(Turma turmaPai) { this.turmaPai = turmaPai; }
    public List<Turma> getTurmasFilhas() { return turmasFilhas; }
    public List<Atividade> getAtividades() { return atividades; }

    public String obterInformacoes() {
        return "Turma: " + nome + " | ID: " + id + " | Descrição: " + descricao + " | Início: " + inicio + " | Fim: " + fim + " | Participantes: " + participantes.size();
    }

    // Métodos de manipulação de participantes
    public void adicionarParticipante(Pessoa pessoa) throws PessoaJaParticipanteException {
        if (participantes.contains(pessoa)) {
            throw new PessoaJaParticipanteException();
        }
        participantes.add(pessoa);
    }

    public void removerParticipante(Pessoa pessoa) throws PessoaNaoEncontradaException {
        if (!participantes.contains(pessoa)) {
            throw new PessoaNaoEncontradaException();
        }
        participantes.remove(pessoa);
    }

    public boolean participa(Pessoa pessoa) {
        return participantes.contains(pessoa);
    }

    public Pessoa[] obtemListaParticipantes() {
        return participantes.toArray(new Pessoa[0]);
    }

    public void associaSubturma(Turma turma) {
        turmasFilhas.add(turma);
    }

    public Professor[] obtemListaProfessores(boolean completa) {
        List<Professor> lista = new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Professor) {
                lista.add((Professor) p);
            }
        }
        if (completa && turmaPai != null) {
            for (Professor prof : turmaPai.obtemListaProfessores(true)) {
                if (!lista.contains(prof)) lista.add(prof);
            }
        }
        return lista.toArray(new Professor[0]);
    }

    public Aluno[] obtemListaAlunos(boolean completa) {
        List<Aluno> lista = new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Aluno) {
                lista.add((Aluno) p);
            }
        }
        if (completa && turmaPai != null) {
            for (Aluno aluno : turmaPai.obtemListaAlunos(true)) {
                if (!lista.contains(aluno)) lista.add(aluno);
            }
        }
        return lista.toArray(new Aluno[0]);
    }

    public Monitor[] obtemListaMonitores(boolean completa) {
        List<Monitor> lista = new ArrayList<>();
        for (Pessoa p : participantes) {
            if (p instanceof Monitor) {
                lista.add((Monitor) p);
            }
        }
        if (completa && turmaPai != null) {
            for (Monitor m : turmaPai.obtemListaMonitores(true)) {
                if (!lista.contains(m)) lista.add(m);
            }
        }
        return lista.toArray(new Monitor[0]);
    }

    // Métodos de manipulação de atividades
    public void associaAtividade(Atividade atividade) throws AtividadeJaAssociadaATurmaException {
        if (atividades.contains(atividade)) {
            throw new AtividadeJaAssociadaATurmaException();
        }
        atividades.add(atividade);
    }

    public void desassociaAtividade(Atividade atividade) throws AtividadeNaoAssociadaATurmaException {
        if (!atividades.contains(atividade)) {
            throw new AtividadeNaoAssociadaATurmaException();
        }
        atividades.remove(atividade);
    }

    public Atividade[] obtemAtividadesDaTurma(boolean completa) {
        List<Atividade> lista = new ArrayList<>(atividades);
        if (completa && turmaPai != null) {
            for (Atividade a : turmaPai.obtemAtividadesDaTurma(true)) {
                if (!lista.contains(a)) lista.add(a);
            }
        }
        return lista.toArray(new Atividade[0]);
    }

    public Atividade[] obtemAtividadesDaTurma(boolean completa, Date inicio, Date fim) {
        List<Atividade> lista = new ArrayList<>();
        for (Atividade a : obtemAtividadesDaTurma(completa)) {
            if (!a.getInicio().before(inicio) && !a.getFim().after(fim)) {
                lista.add(a);
            }
        }
        return lista.toArray(new Atividade[0]);
    }

    public Atividade[] obtemAtividadesDaTurmaCompleta(boolean completa) {
        return obtemAtividadesDaTurma(completa);
    }

    public Atividade[] obtemAtividadesDaTurmaCompleta(boolean completa, Date inicio, Date fim) {
        return obtemAtividadesDaTurma(completa, inicio, fim);
    }

    public Turma obtemTurmaPorID(int idBusca) {
        if (this.id == idBusca) return this;
        for (Turma t : turmasFilhas) {
            Turma encontrada = t.obtemTurmaPorID(idBusca);
            if (encontrada != null) return encontrada;
        }
        return null;
    }

    public Turma[] obtemTurmasDaPessoa(Pessoa pessoa) {
        List<Turma> lista = new ArrayList<>();
        if (participantes.contains(pessoa)) lista.add(this);
        for (Turma t : turmasFilhas) {
            for (Turma turma : t.obtemTurmasDaPessoa(pessoa)) {
                if (!lista.contains(turma)) lista.add(turma);
            }
        }
        return lista.toArray(new Turma[0]);
    }
} 