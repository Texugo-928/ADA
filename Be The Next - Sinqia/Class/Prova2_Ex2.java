package Lista_2;

import java.util.Scanner;

public class Prova2_Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("O programa foi executado sem argumentos, digite manualmente os valores:");

            System.out.println("Informe o primeiro número");
            double numero1 = scanner.nextDouble();

            System.out.println("Informe o segundo número");
            double numero2 = scanner.nextDouble();


            double soma = somarDoisNumeros(numero1, numero2);
            System.out.println(numero1 + " + " + numero2 + " = " + soma);
        }
        else if (args.length == 1) {
            String convercao1 = args[0].replaceAll(",", ".");
            double numero1 = Double.parseDouble(convercao1);


            System.out.println("Faltou informar um parâmetro, digite o número faltante");
            double numero2 = scanner.nextDouble();


            double soma = somarDoisNumeros(numero1, numero2);
            System.out.println(numero1 + " + " + numero2 + " = " + soma);
        }
        else if (args.length == 2) {
            String convercao1 = args[0].replaceAll(",", ".");
            double numero1 = Double.parseDouble(convercao1);
            String convercao2 = args[1].replaceAll(",", ".");
            double numero2 = Double.parseDouble(convercao2);


            double soma = somarDoisNumeros(numero1, numero2);
            System.out.println(numero1 + " + " + numero2 + " = " + soma);
        }
        else {
            System.out.println("Quantidade de parâmetros inválido (Use apenas 2 números)");
        }
    }

    public static double somarDoisNumeros(double numero1, double numero2) {

        double soma = numero1 + numero2;

        return soma;
    }
}