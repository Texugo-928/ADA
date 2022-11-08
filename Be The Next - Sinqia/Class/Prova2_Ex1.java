package Lista_2;

import java.util.Scanner;

public class Prova2_Ex1 {
    public static void main(String[] args) {
        String resposta = classificarParImpar();
        System.out.print(resposta);
    }

    public static String classificarParImpar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número natural");
        double numeroNatural = scanner.nextDouble();


        double resto = numeroNatural%2;


        if (resto == 0) {
            return "O número digitado é Par";
        }
        else if (resto == 1) {
            return "O número digitado é Impar";
        }
        else {
            return "O número digitado não é um número natural";
        }
        }
}

