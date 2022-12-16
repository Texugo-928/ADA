package Logica_de_Programacao_I;

import java.util.Scanner;

public class Prova_1_Exercicio_1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        final int ANOATUAL = 2022;


        System.out.println("Informe o código do empregado: ");
        int codigoEmpregado = input.nextInt();
        System.out.println("Informe o ano de nascimento: ");
        int anoNascimento = input.nextInt();
        System.out.println("Informe o ano de ingresso na empresa: ");
        int anoIngresso = input.nextInt();


        int idade = ANOATUAL - anoNascimento;
        int tempoTrabalho = ANOATUAL - anoIngresso;
        boolean terceiraCondicao = (idade >= 60 && tempoTrabalho >= 25);
        String mensagem = requererAposentadoria(idade, tempoTrabalho, terceiraCondicao);


        System.out.println("O código do empregado é " + codigoEmpregado);
        System.out.println("A idade é " + idade);
        System.out.println("O tempo de trabalho é " + tempoTrabalho);
        System.out.println(mensagem);
    }

    private static String requererAposentadoria(int idade, int tempoTrabalho, boolean terceiraCondicao) {
        String mensagem;
        if (idade >= 65 || tempoTrabalho >= 30 || terceiraCondicao) {
            mensagem = "Requerer aposentadoria";
        }
        else {
            mensagem = "Não requerer";
        }
        return mensagem;
    }
}
