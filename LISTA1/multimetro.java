package multimetro;

//teste
import java.util.Scanner;

public class Multimetro {

    static final int NUM_AMOSTRAS = 10;

    public static void main(String[] args) {
        double volts[] = new double[NUM_AMOSTRAS];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUM_AMOSTRAS; i++) {
            System.out.print("Digite o valor da amostra " + (i + 1) + ": ");
            volts[i] = scanner.nextDouble();
        }

        // Fechar o Scanner quando não for mais necessário
        scanner.close();
        // Cálculo da media
        double media = calcularMedia(volts, NUM_AMOSTRAS);
        System.out.println("\nMedia: " + media);

        // Cálculo do desvio padrão
        double desvioPadrao = calcularDesvioPadrao(volts, media, NUM_AMOSTRAS);
        System.out.println("Desvio Padrão: " + desvioPadrao);

        // Situação do multímetro
        System.out
                .println("Situação: " + ((desvioPadrao > media * 0.1) ? "Multímetro com problema." : "Multímetro OK."));
    }

    public static double calcularMedia(double[] amostras, int numAmostras) {
        double soma = 0;
        for (double amostra : amostras)
            soma += amostra;
        return soma / numAmostras;
    }

    public static double calcularDesvioPadrao(double[] amostras, double media, int numAmostras) {
        double soma = 0;
        for (double amostra : amostras)
            soma += Math.pow(amostra - media, 2);
        return Math.sqrt(soma / numAmostras);
    }
}
