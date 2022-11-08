package Lista_1;

import java.util.Scanner;

public class Ex1_L1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a temperatura em Celcius");
        double temperaturaCelcius = scanner.nextDouble();


        double temperaturaKelvin = temperaturaCelcius + 273.15;
        double temperaturaFahrenheit = temperaturaCelcius * 1.8 + 32;
        double temperaturaRankine = temperaturaCelcius * 1.8 + 32 + 459.67;
        double temperaturaReaumur = temperaturaCelcius * 0.8;



        System.out.printf("A temperatura em Kelvin será %f \n", temperaturaKelvin);
        System.out.printf("A temperatura em Fahrenheit será %f \n", temperaturaFahrenheit);
        System.out.printf("A temperatura em Rankine será %f \n", temperaturaRankine);
        System.out.printf("A temperatura em Reaumur será %f \n", temperaturaReaumur);
    }
}
