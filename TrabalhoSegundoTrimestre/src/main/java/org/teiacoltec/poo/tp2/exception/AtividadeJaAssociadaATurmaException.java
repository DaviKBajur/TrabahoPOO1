package org.teiacoltec.poo.tp2.exception;

public class AtividadeJaAssociadaATurmaException extends Exception {
    public AtividadeJaAssociadaATurmaException() {
        super("Atividade já está associada à turma.");
    }
    public AtividadeJaAssociadaATurmaException(String mensagem) {
        super(mensagem);
    }
} 