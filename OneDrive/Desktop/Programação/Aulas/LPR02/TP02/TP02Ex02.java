import java.util.Scanner;

public class TP02Ex02 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

         //2. Entrar via teclado com dez valores positivos. Consistir a digitação e enviar mensagem de
        //erro, se necessário. Após a digitação, exibir:
        //a. O maior valor;
        //b. A soma dos valores;
        //c. A média aritmética dos valores.

        Scanner scanner = new Scanner(System.in);

        double[] valores = new double[10];
        double soma = 0;
        double maior = Double.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            do {
                System.out.println("Digite o valor " + (i + 1) + " (deve ser positivo):");
                valores[i] = scanner.nextDouble();
            } while (valores[i] < 0);

            soma += valores[i];
            if (valores[i] > maior) {
                maior = valores[i];
            }
        }

        double media = soma / 10;

        System.out.println("O maior valor é: " + maior);
        System.out.println("A soma dos valores é: " + soma);
        System.out.println("A média aritmética dos valores é: " + media);

        scanner.close();
    }
}
