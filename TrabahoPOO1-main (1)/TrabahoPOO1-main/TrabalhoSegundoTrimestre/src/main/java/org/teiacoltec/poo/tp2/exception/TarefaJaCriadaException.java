package org.teiacoltec.poo.tp2.exception;

public class TarefaJaCriadaException extends Exception {
    public TarefaJaCriadaException() {
        super("Tarefa já criada para este aluno e atividade.");
    }
    public TarefaJaCriadaException(String mensagem) {
        super(mensagem);
    }
} 