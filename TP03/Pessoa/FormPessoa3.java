import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPessoa3 extends JFrame {
    private JTextField txtNome, txtIdade;
    private JRadioButton rbtnMasculino, rbtnFeminino;
    private ButtonGroup grupoGenero;
    private JButton btnOk, btnMostrar;
    private JTextArea txtArea;
    private Pessoa umaPessoa;

    public FormPessoa3() {
        setTitle("Cadastro de Pessoa");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtNome = new JTextField(20);
        txtIdade = new JTextField(5);
        rbtnMasculino = new JRadioButton("Masculino");
        rbtnFeminino = new JRadioButton("Feminino");
        grupoGenero = new ButtonGroup();
        btnOk = new JButton("OK");
        btnMostrar = new JButton("Mostrar");
        txtArea = new JTextArea(5, 20);
        txtArea.setEditable(false);

        grupoGenero.add(rbtnMasculino);
        grupoGenero.add(rbtnFeminino);
        
        rbtnMasculino.setSelected(true);

        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Sexo:"));
        add(rbtnMasculino);
        add(rbtnFeminino);
        add(new JLabel("Idade:"));
        add(txtIdade);
        add(btnOk);
        add(btnMostrar);
        add(new JScrollPane(txtArea));

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                char sexo = 'M'; 
                
                if (rbtnFeminino.isSelected()) {
                    sexo = 'F'; 
                }
                
                int idade = Integer.parseInt(txtIdade.getText());

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
                new FormPessoa3().setVisible(true);
            }
        });
    }
}
