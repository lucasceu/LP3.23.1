package lista_01;

import java.util.Random;
import java.util.Scanner;

public class Craps {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int ponto = 0;
        int soma = rollDice(random);
        System.out.println("Você lançou os dados e somou " + soma);
        if (soma == 7 || soma == 11) {
            System.out.println("Você venceu!");
            System.exit(0);
        } else if (soma == 2 || soma == 3 || soma == 12) {
            System.out.println("Craps! Você perdeu.");
            System.exit(0);
        } else {
            System.out.println("O ponto é " + soma);
            ponto = soma;
        }
        while (true) {
            System.out.println("Lançando os dados novamente...");
            soma = rollDice(random);
            System.out.println("Você lançou os dados e somou " + soma);
            if (soma == 7) {
                System.out.println("Você perdeu.");
                break;
            } else if (soma == ponto) {
                System.out.println("Você venceu!");
                break;
            }
        }
        scanner.close();
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }
}