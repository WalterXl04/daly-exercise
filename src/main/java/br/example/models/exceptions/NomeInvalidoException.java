package br.example.models.exceptions;

public class NomeInvalidoException extends RuntimeException {

    public NomeInvalidoException(String msg) {
        super(msg);
    }
}
