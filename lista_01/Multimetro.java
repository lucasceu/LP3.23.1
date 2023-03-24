package lista_01;

import java.util.Scanner;

public class Multimetro {
    public static void main(String[] args) {
        final int QNT_MEDIDAS = 3;
        float[] leituras = new float[QNT_MEDIDAS];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < QNT_MEDIDAS; i++) {
            System.out.printf("Digite a %dª leitura: ", i + 1);
            leituras[i] = scanner.nextFloat();
        }
        float media = calcularMedia(leituras);
        float desvioPadrao = calcularDesvioPadrao(leituras, media);
        System.out.println("\nLeituras:");
        for (int i = 0; i < QNT_MEDIDAS; i++) {
            System.out.printf("%.2f ", leituras[i]);
        }
        System.out.printf("\nMédia: %.2f", media);
        System.out.printf("\nDesvio padrão: %.2f", desvioPadrao);
        if (desvioPadrao > 0.1 * media) {
            System.out.println("\nO multímetro está com problemas e não pode ser utilizado.");
        } else {
            System.out.println("\nO multímetro está operacional.");
        }
        scanner.close();
    }

    public static float calcularMedia(float[] valores) {
        float soma = 0;
        for (float valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    public static float calcularDesvioPadrao(float[] valores, float media) {
        float somaQuadrados = 0;
        for (float valor : valores) {
            somaQuadrados += Math.pow(valor - media, 2);
        }
        float variancia = somaQuadrados / valores.length;
        return (float) Math.sqrt(variancia);
    }
}