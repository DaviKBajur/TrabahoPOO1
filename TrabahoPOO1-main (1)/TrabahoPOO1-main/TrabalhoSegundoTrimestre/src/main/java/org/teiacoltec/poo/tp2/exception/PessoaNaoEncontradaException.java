package org.teiacoltec.poo.tp2.exception;

public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException() {
        super("Pessoa não encontrada.");
    }
    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
} 