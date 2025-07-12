package org.teiacoltec.poo.tp2.exception;

public class PessoaJaParticipanteException extends Exception {
    public PessoaJaParticipanteException() {
        super("Pessoa já é participante da turma.");
    }
    public PessoaJaParticipanteException(String mensagem) {
        super(mensagem);
    }
} 