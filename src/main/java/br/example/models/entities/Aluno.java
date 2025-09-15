package br.example.models.entities;

import br.example.models.exceptions.NomeInvalidoException;
import br.example.models.exceptions.NotaInvalidaException;

public class Aluno {

    private String nome;
    private double nota;

    public Aluno() {}

    public Aluno(String nome, double nota) {
        if(nome == null || nome.trim().isEmpty()){
            throw new NomeInvalidoException("O nome do aluno não pode ser vazio!");
        }
        if(nota < 0 || nota > 10){
            throw new NotaInvalidaException("A nota deve estar entre 0 e 10!");
        }
        this.nome = nome;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nota: " + nota;
    }



}
