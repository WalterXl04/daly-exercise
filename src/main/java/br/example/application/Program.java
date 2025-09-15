package br.example.application;

import br.example.models.entities.Aluno;
import br.example.models.exceptions.NomeInvalidoException;
import br.example.models.exceptions.NotaInvalidaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Aluno> alunos = new ArrayList<>();
        double somaNotas = 0;

        try {
            System.out.print("Quantos alunos deseja cadastrar: ");
            int quantidade = sc.nextInt();
            sc.nextLine(); // Limpa o buffer do teclado

            // --- CORREÇÃO DE LÓGICA: Adicionado o laço FOR ---
            // O laço vai repetir o bloco de código abaixo 'quantidade' de vezes
            for (int i = 0; i < quantidade; i++) {
                System.out.println("\n--- Inserindo dados do aluno #" + (i + 1) + " ---");

                // As perguntas agora estão DENTRO do laço para serem repetidas
                System.out.print("Digite o nome do aluno: ");
                String nome = sc.nextLine();

                System.out.print("Digite a nota: ");
                double nota = sc.nextDouble();
                sc.nextLine(); // Limpa o buffer

                // Cria e adiciona o aluno na lista
                alunos.add(new Aluno(nome, nota));

                // Soma a nota do aluno atual
                somaNotas += nota;
            }

            // --- CORREÇÃO DE SINTAXE: O código de exibição foi movido para DENTRO do TRY ---
            // Ele só será executado após o laço 'for' terminar com sucesso.
            System.out.println("\n--- Cadastro Finalizado ---");

            System.out.println("Alunos na lista:");
            for (Aluno aluno : alunos) {
                System.out.println(aluno);
            }

            if (!alunos.isEmpty()) {
                double media = somaNotas / alunos.size();
                System.out.printf("Média da turma: %.2f\n", media);
            }

        } catch (NomeInvalidoException | NotaInvalidaException e) {
            System.err.println("Erro de validação: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}