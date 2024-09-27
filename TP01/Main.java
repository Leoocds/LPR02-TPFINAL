
public class Main {
    public static void main(String[] args) {
        System.out.println("Executando os testes de Author:");
        TestAuthor.main(args);  // Chama os testes da classe Author

        System.out.println("\nExecutando os testes de Book:");
        TestBook.main(args);  // Chama os testes da classe Book

        System.out.println("\nExecutando os testes de Student e Staff:");
        TestPerson.main(args);  // Chama os testes das classes Student e Staff
    }
}
