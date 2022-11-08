package Lista_1;

import java.util.Scanner;

public class Prova1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira temperatura em graus celcius");
        double celcius1 = scanner.nextDouble();


        System.out.println("Digite a segunda temperatura em graus celcius");
        double celcius2 = scanner.nextDouble();


        double fahrenheit1 = converterCelciusFahrenheit(celcius1);
        System.out.printf("%f Celcius equivale a %f Fahrenheit \n", celcius1, fahrenheit1);

        double fahrenheit2 = converterCelciusFahrenheit(celcius2);
        System.out.printf("%f Celcius equivale a %f Fahrenheit \n", celcius2, fahrenheit2);
    }
        public static double converterCelciusFahrenheit(Double celcius) {
        final double FATOR_1 = 9.0 / 5.0;
        final double FATOR_2 = 32.0;

        double fahrenheit = (celcius * FATOR_1) + FATOR_2;

        return fahrenheit;
    }
}