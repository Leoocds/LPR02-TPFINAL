import javax.swing.*;
import java.awt.*;

public class Ex03 extends JFrame {

    private JComboBox<String> colorComboBox;
    private JRadioButton backgroundRadioButton;
    private JRadioButton foregroundRadioButton;
    private JButton okButton;
    private JButton cancelButton;

    public Ex03() {
        setTitle("ColorSelect");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        colorComboBox = new JComboBox<>();
        colorComboBox.addItem("RED");
        colorComboBox.addItem("GREEN");
        colorComboBox.addItem("BLUE");

        add(colorComboBox, BorderLayout.NORTH);

        JPanel radioPanel = new JPanel();
        backgroundRadioButton = new JRadioButton("Background");
        foregroundRadioButton = new JRadioButton("Foreground");

        ButtonGroup group = new ButtonGroup();
        group.add(backgroundRadioButton);
        group.add(foregroundRadioButton);

        radioPanel.add(backgroundRadioButton);
        radioPanel.add(foregroundRadioButton);

        add(radioPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex03();
    }
}
