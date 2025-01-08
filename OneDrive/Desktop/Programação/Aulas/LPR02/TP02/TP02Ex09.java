import java.util.Scanner;

public class TP02Ex09 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //9. Entrar com uma matriz de ordem MxN, onde a ordem também será escolhida pelo usuário,
        //sendo que no máximo 10x10. A matriz não precisa ser quadrática. Após a digitação dos
        //elementos, calcular e exibir a matriz transposta.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de linhas da matriz (no máximo 10):");
        int M = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da matriz (no máximo 10):");
        int N = scanner.nextInt();
    
        double[][] matriz = new double[M][N];
        double[][] matrizTransposta = new double[N][M];
    
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println("Digite o valor para a posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
                matrizTransposta[j][i] = matriz[i][j];
            }
        }
    
        System.out.println("A matriz original é:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    
        System.out.println("A matriz transposta é:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrizTransposta[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
