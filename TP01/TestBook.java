
public class TestBook {
    public static void main(String[] args) {
        // Criar autores
        Ex01[] authors = new Ex01[2];
        authors[0] = new Ex01("Autor 01", "autor01@somewhere.com.br", 'm');
        authors[1] = new Ex01("Autor 02", "autor02@nowhere.com.br", 'm');

        // Criar o livro
        Ex02 book = new Ex02("Java for Dummy", authors, 19.99, 99);

        // Testar toString()
        System.out.println(book);  // Esperado: Book[name=Java for Dummy,authors={Author[name=Autor 01,email=autor01@somewhere.com.br,gender=m],Author[name=Autor 02,email=autor02@nowhere.com.br,gender=m],},price=19.99,qty=99]

        // Testar setters e getters
        book.setPrice(25.99);
        book.setQty(120);
        System.out.println("Novo preço: " + book.getPrice());  // Esperado: 25.99
        System.out.println("Nova quantidade: " + book.getQty());  // Esperado: 120
    }
}