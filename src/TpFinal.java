// LEONARDO DE LIMA PEDROSO - CB3026655
// EVERSON PEREIRA DA SILVA - CB3026353

package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import org.json.JSONObject;

public class TpFinal {
    private JFrame frame;
    private JTextField txtNome;
    private JLabel lblNome;
    private JLabel lblIdade;
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JLabel lblObjetivo;
    private JTextField txtIdade;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JTextField txtObjetivo;
    private JButton btnIncluir;
    private JButton btnLimpar;
    private JButton btnApresentar;
    private JButton btnSair;

    private Connection connection;

    public TpFinal() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame("Cadastro de Aluno");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 20);
        frame.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 200, 20);
        frame.add(txtNome);

        lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 60, 80, 20);
        frame.add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(100, 60, 200, 20);
        frame.add(txtIdade);

        lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(20, 100, 80, 20);
        frame.add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(100, 100, 200, 20);
        frame.add(txtPeso);

        lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(20, 140, 80, 20);
        frame.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(100, 140, 200, 20);
        frame.add(txtAltura);

        lblObjetivo = new JLabel("Objetivo:");
        lblObjetivo.setBounds(20, 180, 80, 20);
        frame.add(lblObjetivo);

        txtObjetivo = new JTextField();
        txtObjetivo.setBounds(100, 180, 200, 20);
        frame.add(txtObjetivo);

        btnIncluir = new JButton("Incluir");
        btnIncluir.setBounds(20, 220, 100, 30);
        frame.add(btnIncluir);

        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(130, 220, 100, 30);
        frame.add(btnLimpar);

        btnApresentar = new JButton("Apresentar Dados");
        btnApresentar.setBounds(240, 220, 150, 30);
        frame.add(btnApresentar);

        btnSair = new JButton("Sair");
        btnSair.setBounds(400, 220, 100, 30);
        frame.add(btnSair);

        btnIncluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirAluno();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        btnApresentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apresentarDados();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpfinal?useSSL=false&serverTimezone=America/Sao_Paulo", "root", "aulinha123");
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception var2) {
            var2.printStackTrace();
            JOptionPane.showMessageDialog(this.frame, "Erro ao conectar ao banco de dados!", "Erro", 0);
        }
    }

    private void incluirAluno() {
        try {
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            float altura = Float.parseFloat(txtAltura.getText());
            String objetivo = txtObjetivo.getText();

            String query = "INSERT INTO alunos (nome, idade, peso, altura, objetivo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setFloat(3, peso);
            statement.setFloat(4, altura);
            statement.setString(5, objetivo);
            statement.executeUpdate();

            JOptionPane.showMessageDialog(frame, "Aluno incluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao incluir aluno!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtIdade.setText("");
        txtPeso.setText("");
        txtAltura.setText("");
        txtObjetivo.setText("");
    }

    private void apresentarDados() {
        try {
            String nome = txtNome.getText();
            String query = "SELECT * FROM alunos WHERE nome LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                txtIdade.setText(String.valueOf(resultSet.getInt("idade")));
                txtPeso.setText(String.valueOf(resultSet.getFloat("peso")));
                txtAltura.setText(String.valueOf(resultSet.getFloat("altura")));
                txtObjetivo.setText(resultSet.getString("objetivo"));

                JSONObject alunoJson = new JSONObject();
                alunoJson.put("Nome", resultSet.getString("nome"));
                alunoJson.put("Idade", resultSet.getInt("idade"));
                alunoJson.put("Peso", resultSet.getFloat("peso"));
                alunoJson.put("Altura", resultSet.getFloat("altura"));
                alunoJson.put("Objetivo", resultSet.getString("objetivo"));

                JOptionPane.showMessageDialog(frame, alunoJson.toString(4), "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(alunoJson.toString(4));
                JOptionPane.showMessageDialog(null, alunoJson.toString(4), "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Aluno não encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao apresentar dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TpFinal::new);
    }
}
