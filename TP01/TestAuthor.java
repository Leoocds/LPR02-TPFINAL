
public class TestAuthor {
    public static void main(String[] args) {
        // Testar o construtor
        Ex01 author = new Ex01("Wellington Tuler", "tulermoraes@yahoo.com", 'm');
        
        // Testar o método toString()
        System.out.println(author);  // Esperado: Author[name=Wellington Tuler,email=tulermoraes@yahoo.com,gender=m]
        
        // Testar os Getters
        System.out.println("Nome: " + author.getName());  // Esperado: Wellington Tuler
        System.out.println("Email: " + author.getEmail());  // Esperado: tulermoraes@yahoo.com
        System.out.println("Gênero: " + author.getGender());  // Esperado: m
        
        // Testar o Setter
        author.setEmail("novoemail@example.com");
        System.out.println("Email atualizado: " + author.getEmail());  // Esperado: novoemail@example.com
    }
}