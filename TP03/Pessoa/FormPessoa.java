import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa extends JFrame {
    private JTextField txtNome, txtIdade, txtGenero;
    private JButton btnOk, btnMostrar;
    private JTextArea txtArea;
    private Pessoa umaPessoa;

    public FormPessoa() {
        setTitle("Cadastro de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtNome = new JTextField(20);
        txtIdade = new JTextField(5);
        txtGenero = new JTextField(1);
        btnOk = new JButton("OK");
        btnMostrar = new JButton("Mostrar");
        txtArea = new JTextArea(5, 20);
        txtArea.setEditable(false);

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Sexo(M/F):"));
        add(txtGenero);
        add(new JLabel("Idade:"));
        add(txtIdade);
        add(btnOk);
        add(btnMostrar);
        add(new JScrollPane(txtArea));

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String sexoStr = txtGenero.getText().toUpperCase(); // Captura o sexo e converte para maiúsculo
                int idade = Integer.parseInt(txtIdade.getText());

                if (!sexoStr.equals("M") && !sexoStr.equals("F")) {
                    txtArea.setText("Sexo inválido! Use 'M' ou 'F'.");
                    return;
                }

                char sexo = sexoStr.charAt(0); 

                umaPessoa = new Pessoa(nome, sexo, idade);

                txtArea.setText("Pessoa cadastrada!\nNúmero: " + umaPessoa.getKp());
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    txtArea.setText("Nome: " + umaPessoa.getNome() + "\n");
                    txtArea.append("Sexo: " + umaPessoa.getSexo() + "\n");
                    txtArea.append("Idade: " + umaPessoa.getIdade() + "\n");
                    txtArea.append("Número: " + umaPessoa.getKp() + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormPessoa().setVisible(true);
            }
        });
    }
}
