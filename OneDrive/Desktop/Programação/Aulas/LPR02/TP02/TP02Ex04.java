import java.util.Scanner;

public class TP02Ex04 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //4. Armazenar seis valores em uma matriz de ordem 2x3. Apresentar os valores na tela.

        Scanner scanner = new Scanner(System.in);

        double[][] matriz = new double[2][3];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Digite o valor da posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Os valores da matriz são:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
