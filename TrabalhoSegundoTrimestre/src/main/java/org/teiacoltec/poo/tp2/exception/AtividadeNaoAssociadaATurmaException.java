package org.teiacoltec.poo.tp2.exception;

public class AtividadeNaoAssociadaATurmaException extends Exception {
    public AtividadeNaoAssociadaATurmaException() {
        super("Atividade não está associada à turma.");
    }
    public AtividadeNaoAssociadaATurmaException(String mensagem) {
        super(mensagem);
    }
} 