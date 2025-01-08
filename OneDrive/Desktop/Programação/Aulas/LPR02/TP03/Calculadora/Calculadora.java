import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
    private JTextField display;
    private StringBuilder input = new StringBuilder();
    private double resultado = 0;
    private String operador = "";
    
    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new BorderLayout());
        
        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        
        String[] botoes = {"7", "8", "9", "/", "4", "5", "6", "*", 
            "1", "2", "3", "-", "0", "C", "=", "+"};
        
        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.PLAIN, 20));
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    processarBotao(e.getActionCommand());
                }
            });
            panel.add(botao);
        }
        
        add(panel, BorderLayout.CENTER);
    }
    
    private void processarBotao(String comando) {
        try {
            switch (comando) {
                case "=":
                    if (!operador.isEmpty()) {
                        double num = Double.parseDouble(input.toString());
                        switch (operador) {
                            case "+":
                                resultado += num;
                                break;
                            case "-":
                                resultado -= num;
                                break;
                            case "*":
                                resultado *= num;
                                break;
                            case "/":
                                if (num == 0) {
                                    throw new ArithmeticException("Não pode dividir por zero.");
                                }
                                resultado /= num;
                                break;
                        }
                        display.setText(String.valueOf(resultado));
                        input.setLength(0);
                        operador = "";
                    }
                    break;
                case "C":
                    input.setLength(0);
                    resultado = 0;
                    operador = "";
                    display.setText("0");
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    if (input.length() > 0) {
                        resultado = Double.parseDouble(input.toString());
                        input.setLength(0);
                    }
                    operador = comando;
                    break;
                default:
                    if (input.length() == 1 && input.toString().equals("0")) {
                        input.setLength(0);
                    }
                    input.append(comando);
                    display.setText(input.toString());
                    break;
            }
        } catch (Exception e) {
            display.setText("Erro");
        } finally {
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
}
