import java.util.Scanner;

public class TP02Ex03 {
    public static void main(String[] args) {
        //Sergio Wu CB3025691 e Leonardo de Lima CB3026655

        //3. Entrar via teclado com “N” valores quaisquer. O valor “N” (que representa a quantidade de
        //números) será digitado, deverá ser positivo, porém menor que vinte. Caso a quantidade não
        //satisfaça a restrição, enviar mensagem de erro e solicitar o valor novamente. Após a
        // digitação dos “N” valores, exibir:
        //a. O maior valor;
        //b. O menor valor;
        //c. A soma dos valores;
        //d. A média aritmética dos valores;
        //e. A porcentagem de valores que são positivos;
        //f. A porcentagem de valores negativos;
        //Após exibir os dados, perguntar ao usuário de deseja ou não uma nova execução do
        //programa. Consistir a resposta no sentido de aceitar somente “S” ou “N” e encerrar o
        //programa em função dessa resposta.

        Scanner scanner = new Scanner(System.in);

        int N;
        do {
            System.out.println("Digite a quantidade de números (deve ser positivo e menor que 20):");
            N = scanner.nextInt();
        } while (N <= 0 || N >= 20);
    
        double[] valores = new double[N];
        double soma = 0;
        double maior = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        int countPos = 0;
        int countNeg = 0;
    
        for (int i = 0; i < N; i++) {
            System.out.println("Digite o valor " + (i + 1) + ":");
            valores[i] = scanner.nextDouble();
    
            soma += valores[i];
            if (valores[i] > maior) {
                maior = valores[i];
            }
            if (valores[i] < menor) {
                menor = valores[i];
            }
            if (valores[i] > 0) {
                countPos++;
            } else if (valores[i] < 0) {
                countNeg++;
            }
        }
    
        double media = soma / N;
        double percPos = (double) countPos / N * 100;
        double percNeg = (double) countNeg / N * 100;
    
        System.out.println("O maior valor é: " + maior);
        System.out.println("O menor valor é: " + menor);
        System.out.println("A soma dos valores é: " + soma);
        System.out.println("A média aritmética dos valores é: " + media);
        System.out.println("A porcentagem de valores que são positivos é: " + percPos + "%");
        System.out.println("A porcentagem de valores que são negativos é: " + percNeg + "%");

        scanner.close();
    }
}
