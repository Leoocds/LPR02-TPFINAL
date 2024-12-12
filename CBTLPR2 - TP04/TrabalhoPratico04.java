import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Stack;

public class TrabalhoPratico04 extends JFrame {
    private JTextField txtNomePesquisa, txtNome, txtSalario, txtCargo;
    private JButton btnPesquisar, btnAnterior, btnProximo;
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet resultSet;

    private Stack<String> historicoPesquisas = new Stack<>();
    private String nomeAtual;

    public TrabalhoPratico04() {
        setTitle("TRABALHO PRATICO 04");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblPesquisa = new JLabel("Nome:");
        lblPesquisa.setBounds(20, 20, 50, 20);
        add(lblPesquisa);

        txtNomePesquisa = new JTextField();
        txtNomePesquisa.setBounds(80, 20, 200, 20);
        add(txtNomePesquisa);

        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(290, 20, 100, 20);
        add(btnPesquisar);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 60, 50, 20);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(80, 60, 200, 20);
        txtNome.setEditable(false);
        add(txtNome);

        JLabel lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(20, 100, 50, 20);
        add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(80, 100, 200, 20);
        txtSalario.setEditable(false);
        add(txtSalario);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(20, 140, 50, 20);
        add(lblCargo);

        txtCargo = new JTextField();
        txtCargo.setBounds(80, 140, 200, 20);
        txtCargo.setEditable(false);
        add(txtCargo);

        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(50, 200, 100, 30);
        add(btnAnterior);

        btnProximo = new JButton("Próximo");
        btnProximo.setBounds(200, 200, 100, 30);
        add(btnProximo);

        btnPesquisar.addActionListener(e -> pesquisarFuncionario());
        btnAnterior.addActionListener(e -> navegarHistorico(false));
        btnProximo.addActionListener(e -> navegarHistorico(true));

        setVisible(true);
    }

    private void pesquisarFuncionario() {
        String nome = txtNomePesquisa.getText();

        try {
            if (resultSet != null) resultSet.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TrabalhoPratico04", "root", "*Consagrado712");
            ps = conn.prepareStatement(
                "SELECT f.nome_func, f.sal_func, c.ds_cargo " +
                "FROM tbfuncs f " +
                "JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                "WHERE f.nome_func LIKE ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );
            ps.setString(1, "%" + nome + "%");
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                nomeAtual = nome;
                if (historicoPesquisas.isEmpty() || !historicoPesquisas.peek().equals(nome)) {
                    historicoPesquisas.push(nome);
                }
                exibirDados();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao pesquisar: " + ex.getMessage());
        }
    }

    private void navegarHistorico(boolean proximo) {
        if (historicoPesquisas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhuma pesquisa realizada.");
            return;
        }

        if (proximo) {
            if (!historicoPesquisas.isEmpty()) {
                nomeAtual = historicoPesquisas.peek();
                executarPesquisaDoHistorico();
            } else {
                JOptionPane.showMessageDialog(this, "Não há mais registros.");
            }
        } else {
            if (historicoPesquisas.size() > 1) {
                historicoPesquisas.pop();
                nomeAtual = historicoPesquisas.peek();
                executarPesquisaDoHistorico();
            } else {
                JOptionPane.showMessageDialog(this, "Não há mais registros.");
            }
        }
    }

    private void executarPesquisaDoHistorico() {
        try {
            if (resultSet != null) resultSet.close();
            if (ps != null) ps.close();

            ps = conn.prepareStatement(
                "SELECT f.nome_func, f.sal_func, c.ds_cargo " +
                "FROM tbfuncs f " +
                "JOIN tbcargos c ON f.cod_cargo = c.cd_cargo " +
                "WHERE f.nome_func LIKE ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );
            ps.setString(1, "%" + nomeAtual + "%");
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                exibirDados();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao executar histórico: " + ex.getMessage());
        }
    }

    private void exibirDados() throws SQLException {
        txtNome.setText(resultSet.getString("nome_func"));
        txtSalario.setText(String.valueOf(resultSet.getBigDecimal("sal_func")));
        txtCargo.setText(resultSet.getString("ds_cargo"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrabalhoPratico04::new);
    }
}
