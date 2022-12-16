package Coding_Tank.Prova;

import java.util.Scanner;

public class Prova_2_Exercicio_3 {
    public static void main(String[] args) {
        inicializar();

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                somar();
                break;
            case 2:
                subtrair();
                break;
            case 3:
                multiplicar();
                break;
            case 4:
                dividir();
                break;
            default:
                System.out.println("Opção Inválida");
                break;
        }
    }

    public static void inicializar() {
        System.out.println("Escolha o número que representa a operação:");
        System.out.println("1 --- soma (+)");
        System.out.println("2 --- subtração (-)");
        System.out.println("3 --- multiplicação (*)");
        System.out.println("4 --- divisão (/)");
    }
    public static void somar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o segundo número");
        double numero2 = scanner.nextDouble();

        double soma = numero1 + numero2;

        System.out.println("O resultado da soma é " + soma);
    }
    public static void subtrair() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o minuendo");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o subtraendo");
        double numero2 = scanner.nextDouble();

        double subtracao = numero1 - numero2;

        System.out.println("O resultado da subtração é " + subtracao);
    }
    public static void multiplicar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o multiplicando");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o multiplicador");
        double numero2 = scanner.nextDouble();

        double multiplicacao = numero1 * numero2;

        System.out.println("O resultado da multiplicação é " + multiplicacao);
    }
    public static void dividir() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o dividendo");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o divisor");
        double numero2 = scanner.nextDouble();

        double divisao = numero1 / numero2;

        System.out.println("O resultado da divisão é " + divisao);
    }
}
