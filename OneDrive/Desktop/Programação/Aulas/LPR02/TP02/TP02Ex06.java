import java.util.Scanner;

public class TP02Ex06 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //6. Armazenar seis nomes em uma matriz de ordem 2x3. Apresentar os nomes na tela.

        Scanner scanner = new Scanner(System.in);

        String[][] matriz = new String[2][3];
    
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Digite o nome para a posição [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.next();
            }
        }
    
        System.out.println("Os nomes na matriz são:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
