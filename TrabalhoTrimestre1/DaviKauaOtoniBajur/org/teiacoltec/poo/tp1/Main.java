package org.teiacoltec.poo.tp1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Professor prof = new Professor("13", "Leo", new Date(), "maia@ufmg.br", "Rua A", "2020", "SuperDoutorado");
            Aluno aluno = new Aluno("951", "Davi", new Date(), "bajur@ufmg.br", "Rua B", "2023", "Info/Ds");

            System.out.println("\n=== Informações do Professor ===");
            imprimirInformacoes(prof);
            System.out.println("\n=== Informações do Aluno ===");
            imprimirInformacoes(aluno);

            Turma turma = new Turma(1, "POO", "Turma de Programação", new Date(), new Date());
            turma.adicionarParticipante(prof);
            turma.adicionarParticipante(aluno);

            Atividade atividade = new Atividade(10, "Trabalho 1", "Primeira avaliação", new Date(), new Date());

            System.out.println("\n=== Informações da Turma ===");
            turma.imprimirDetalhes();

            System.out.println("\n=== Informações da Atividade ===");
            atividade.imprimirDetalhes();

            turma.removerParticipante(new Aluno("999", "Inexistente", new Date(), "puft@", "none", "X", "none"));

        } catch (PessoaNaoEncontradaException | PessoaJaParticipanteException e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    public static void imprimirInformacoes(Pessoa pessoa) {
        System.out.println(pessoa.obterInformacoes());
    }

}
