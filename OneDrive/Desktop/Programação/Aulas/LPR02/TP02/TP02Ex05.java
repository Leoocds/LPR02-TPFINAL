import java.util.Scanner;

public class TP02Ex05 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //5. Armazenar seis valores em uma matriz de ordem 3x2. Apresentar os valores na tela.

        Scanner scanner = new Scanner(System.in);

        double[][] matriz = new double[3][2];
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Digite o valor da posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }
    
        System.out.println("Os valores da matriz são:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
