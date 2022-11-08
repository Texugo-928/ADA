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


        System.out.println("A temperatura em Kelvin será " + temperaturaKelvin);
        System.out.println("A temperatura em Fahrenheit será " + temperaturaFahrenheit);
        System.out.println("A temperatura em Rankine será " + temperaturaRankine);
        System.out.println("A temperatura em Reaumur será " + temperaturaReaumur);
    }
}
