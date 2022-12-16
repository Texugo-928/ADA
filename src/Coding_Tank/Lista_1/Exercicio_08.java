package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a distância total percorrida pelo automóvel em quilometros");
        double distanciaTotalPercorrida = scanner.nextDouble();

        System.out.println("Informe o total de combustível gasto em litros");
        double combustivelGasto = scanner.nextDouble();


        double consumoMedio = distanciaTotalPercorrida / combustivelGasto;


        System.out.printf("O consumo médio do automóvel é %.2f km/l \n", consumoMedio);
    }
}