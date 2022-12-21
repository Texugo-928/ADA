package Logica_de_Programacao_I;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Prova_1_Exercicio_1 {
    private static final Scanner input = new Scanner(System.in);
    private static final int ANOATUAL = 2022;

    // TODO Tratar entrada de dados inválidos

    public static void main(String args[]) {
        int[] entradas = receberEntradas();
        String mensagem = requererAposentadoria(entradas);
        saida(entradas, mensagem);
    }

    private static void saida(int[] entradas, String mensagem) {
        int idade = ANOATUAL - entradas[1];
        int tempoTrabalho = ANOATUAL - entradas[2];
        System.out.println("O código do empregado é " + entradas[0]);
        System.out.println("A idade é " + idade);
        System.out.println("O tempo de trabalho é " + tempoTrabalho);
        System.out.println(mensagem);
    }

    private static String requererAposentadoria(int[] entradas) {
        int idade = ANOATUAL - entradas[1];
        int tempoTrabalho = ANOATUAL - entradas[2];
        boolean terceiraCondicao = (idade >= 60 && tempoTrabalho >= 25);
        String mensagem;

        if (idade >= 65 || tempoTrabalho >= 30 || terceiraCondicao) {
            mensagem = "Requerer aposentadoria";
        }
        else {
            mensagem = "Não requerer";
        }
        return mensagem;
    }

    private static int[] receberEntradas() {
        System.out.println("Informe o código do empregado: ");
        int codigoEmpregado = input.nextInt();
        System.out.println("Informe o ano de nascimento: ");
        int anoNascimento = input.nextInt();
        System.out.println("Informe o ano de ingresso na empresa: ");
        int anoIngresso = input.nextInt();

        return new int[]{codigoEmpregado, anoNascimento, anoIngresso};
    }

}
