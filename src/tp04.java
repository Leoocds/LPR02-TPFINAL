// LEONARDO DE LIMA PEDROSO - CB3026655
// EVERSON PEREIRA DA SILVA - CB3026353

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Stack;

public class tp04 {
    private JFrame frame;
    private JTextField txtNome;
    private JLabel lblNome;
    private JLabel lblSalario;
    private JLabel lblCargo;
    private JTextField txtSalario;
    private JTextField txtCargo;
    private JTextField txtnomefind;
    private JButton btnPesquisar;
    private JButton btnAnterior;
    private JButton btnProximo;

    private Connection connection;
    private ResultSet resultSet;
    private int cod_funcAtual;  

    public tp04() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        // Inicializando o frame com título e tamanho
        frame = new JFrame("TRABALHO PRÁTICO 04");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout nulo para posicionamento manual dos componentes
        
        // Campo de pesquisa de nome
        JLabel lblPesquisa = new JLabel("Nome:");
        lblPesquisa.setBounds(20, 20, 50, 20);
        frame.add(lblPesquisa);

        txtNome = new JTextField();
        txtNome.setBounds(80, 20, 200, 20);
        frame.add(txtNome);

        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(290, 20, 100, 20);
        frame.add(btnPesquisar);

        // Exibição do nome, salário e cargo
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 60, 50, 20);
        frame.add(lblNome);

        txtnomefind = new JTextField();
        txtnomefind.setBounds(80, 60, 200, 20);
        txtnomefind.setEditable(false);
        frame.add(txtnomefind);

        lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(20, 100, 50, 20);
        frame.add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(80, 100, 200, 20);
        txtSalario.setEditable(false);
        frame.add(txtSalario);

        lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(20, 140, 50, 20);
        frame.add(lblCargo);

        txtCargo = new JTextField();
        txtCargo.setBounds(80, 140, 200, 20);
        txtCargo.setEditable(false);
        frame.add(txtCargo);

        // Botões de navegação
        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(50, 200, 100, 30);
        frame.add(btnAnterior);

        btnProximo = new JButton("Próximo");
        btnProximo.setBounds(200, 200, 100, 30);
        frame.add(btnProximo);

        // Ações dos botões
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchRecord(txtNome.getText());
            }
        });

        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateRecord(false);
            }
        });

        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateRecord(true);
            }
        });

        frame.setVisible(true);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulajava?useSSL=false&serverTimezone=America/Sao_Paulo", "root", "aulinha123");
            System.out.println("Conexão bem-sucedida!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchRecord(String nome) {
        try {
            
            String query = "SELECT f.cod_func, f.nome_func, f.sal_func, c.ds_cargo " +
                           "FROM tbfuncs f " +
                           "JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " + 
                           "WHERE f.nome_func LIKE ? LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + nome + "%");
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cod_funcAtual = resultSet.getInt("cod_func"); 
                displayRecord();  
            } else {
                JOptionPane.showMessageDialog(frame, "Nenhum registro encontrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao buscar o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void navigateRecord(boolean next) {
        try {
            int novoCodFunc = next ? cod_funcAtual + 1 : cod_funcAtual - 1;

            
            String query = "SELECT f.cod_func, f.nome_func, f.sal_func, c.ds_cargo " +
                           "FROM tbfuncs f " +
                           "JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " + 
                           "WHERE f.cod_func = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, novoCodFunc);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cod_funcAtual = novoCodFunc;  
                displayRecord();  
            } else {
                String direcao = next ? "próximos" : "anteriores";
                JOptionPane.showMessageDialog(frame, "Não há mais registros " + direcao + "!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao navegar nos registros!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayRecord() {
        try {
            String nome = resultSet.getString("nome_func");
            String salario = resultSet.getString("sal_func");
            String cargo = resultSet.getString("ds_cargo");

            txtnomefind.setText(nome);
            txtSalario.setText(salario);
            txtCargo.setText(cargo);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Erro ao exibir o registro!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(tp04::new);  
    }
}
