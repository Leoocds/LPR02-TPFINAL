import java.util.Scanner;

public class TP02Ex10 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //10. Entrar com uma matriz de ordem MxM, onde a ordem também será escolhida pelo usuário,
        //sendo que no máximo será de ordem 10 e quadrática. Após a digitação dos elementos,
        //calcular e exibir a matriz inversa. Exibir as matrizes na tela, sob a forma matricial (linhas x
        //colunas).

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a ordem da matriz quadrada (no máximo 10):");
        int M = scanner.nextInt();
    
        double[][] matriz = new double[M][M];
        double[][] matrizInversa = new double[M][M];
    
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.println("Digite o valor para a posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }
    
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrizInversa[i][j] = (i == j) ? 1 : 0;
            }
        }
    
        System.out.println("A matriz original é:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    
        System.out.println("A matriz inversa é:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrizInversa[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
