import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex02 extends JFrame {
    private JTextArea leftTextArea;
    private JTextArea rightTextArea;
    private JButton copyButton;

    public Ex02() {
        setTitle("TextArea Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        leftTextArea = new JTextArea("Este é um demo para ilustrar a utilização de textarea", 5, 10);
        JScrollPane leftScrollPane = new JScrollPane(leftTextArea);

        rightTextArea = new JTextArea(5, 10);
        JScrollPane rightScrollPane = new JScrollPane(rightTextArea);

        copyButton = new JButton("Copy >>>");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rightTextArea.setText(leftTextArea.getText());
            }
        });

        JPanel textPanel = new JPanel(new GridLayout(1, 2));
        textPanel.add(leftScrollPane);
        textPanel.add(rightScrollPane);

        add(textPanel, BorderLayout.CENTER);
        add(copyButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex02();
    }
}

