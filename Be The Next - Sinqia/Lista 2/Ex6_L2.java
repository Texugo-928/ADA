package Lista_2;

import java.util.Scanner;

public class Ex6_L2 {
    public static void main(String args[]) {
        double[] numeros = inserirQuatroNumeros();

        double numeroQuadrado1 = calcularQuadradoNumero(numeros[0]);
        System.out.printf("O número %f ao quadrado vale %f \n", numeros[0], numeroQuadrado1);

        double numeroQuadrado2 = calcularQuadradoNumero(numeros[1]);
        System.out.printf("O número %f ao quadrado vale %f \n", numeros[1], numeroQuadrado2);

        double numeroQuadrado3 = calcularQuadradoNumero(numeros[2]);
        System.out.printf("O número %f ao quadrado vale %f \n", numeros[2], numeroQuadrado3);

        double numeroQuadrado4 = calcularQuadradoNumero(numeros[3]);
        System.out.printf("O número %f ao quadrado vale %f \n", numeros[3], numeroQuadrado4);


        double somaQuadrado = numeroQuadrado1 + numeroQuadrado2 + numeroQuadrado3 + numeroQuadrado4;


        System.out.println("O valor da soma será de " + somaQuadrado);

    }

    public static double[] inserirQuatroNumeros() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro número");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o segundo número");
        double numero2 = scanner.nextDouble();

        System.out.println("Informe o terceiro número");
        double numero3 = scanner.nextDouble();

        System.out.println("Informe o quarto número");
        double numero4 = scanner.nextDouble();

        double[] numeros = {numero1, numero2, numero3, numero4};

        return numeros;
    }

    public static double calcularQuadradoNumero(double numero) {

        double quadrado = numero * numero;

        return quadrado;
    }
}