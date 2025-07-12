package org.teiacoltec.poo.tp2.exception;

public class AtividadeNaoPertenceATurmaException extends Exception {
    public AtividadeNaoPertenceATurmaException() {
        super("Atividade não pertence à turma.");
    }
    public AtividadeNaoPertenceATurmaException(String mensagem) {
        super(mensagem);
    }
} 