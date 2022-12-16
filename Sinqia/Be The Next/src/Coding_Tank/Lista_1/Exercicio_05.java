package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o salário do funcionário");
        double salario = scanner.nextDouble();

        double salarioAntes = salario;
        final double REAJUSTE_SALARIAL = 0.07;


        salario += (salario * REAJUSTE_SALARIAL);


        System.out.printf("O valor do salário antes do reajuste é %.2f \n", salarioAntes);
        System.out.printf("O valor do salário após o reajuste é %.2f \n", salario);
    }
}
