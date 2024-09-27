public class Ex01 {
    private String name;
    private String email;
    private char gender; 

    public Ex01(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author[name=" + name + ",email=" + email + ",gender=" + gender + "]";
    }

    public static void main(String[] args) {
        Ex01 author = new Ex01("Wellington Tuler", "tulermoraes@yahoo.com", 'm');
        System.out.println(author); 
        System.out.println("Name: " + author.getName()); 
        System.out.println("Email: " + author.getEmail()); 
        System.out.println("Gender: " + author.getGender()); 

        author.setEmail("novoemail@example.com"); 
        System.out.println("Updated Email: " + author.getEmail());
    }
}
