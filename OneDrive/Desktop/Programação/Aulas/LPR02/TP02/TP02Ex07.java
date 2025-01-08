import java.util.Scanner;

public class TP02Ex07 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //7. Entrar via teclado com doze valores e armazená-los em uma matriz de ordem 3x4. Após a
        //digitação dos valores solicitar uma constante multiplicativa, que deverá multiplicar cada
        //valor matriz e armazenar o resultado na própria matriz, nas posições correspondentes.

        Scanner scanner = new Scanner(System.in);

        double[][] matriz = new double[3][4];
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Digite o valor para a posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextDouble();
            }
        }
    
        System.out.println("Digite a constante multiplicativa:");
        double constante = scanner.nextDouble();
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] *= constante;
            }
        }
    
        System.out.println("Os valores da matriz após a multiplicação são:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
