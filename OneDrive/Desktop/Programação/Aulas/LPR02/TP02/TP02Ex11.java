import java.util.Scanner;

public class TP02Ex11 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //11. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
        //sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
        //calcular e exibir determinante da matriz.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a ordem da matriz quadrada (no máximo 10):");
        int M = scanner.nextInt();
    
        double[][] matriz = new double[M][M];
    
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.println("Digite o valor para a posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }
    
        double determinante = 0;
    
        if (M == 2) {
            determinante = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        } else if (M == 3) {
            determinante = matriz[0][0] * matriz[1][1] * matriz[2][2]
                         + matriz[0][1] * matriz[1][2] * matriz[2][0]
                         + matriz[0][2] * matriz[1][0] * matriz[2][1]
                         - matriz[0][2] * matriz[1][1] * matriz[2][0]
                         - matriz[0][1] * matriz[1][0] * matriz[2][2]
                         - matriz[0][0] * matriz[1][2] * matriz[2][1];
        } else {
            System.out.println("O cálculo do determinante para matrizes de ordem maior que 3 não foi implementado.");
            return;
        }
    
        System.out.println("O determinante da matriz é: " + determinante);

        scanner.close();
    }
}
