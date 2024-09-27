import javax.swing.*;
import java.awt.*;

public class Ex01 extends JFrame {
    public Ex01() {
        setTitle("Printer");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 5, 5));

        JLabel label = new JLabel("Printer: MyPrinter");
        panel.add(label);

        JCheckBox imageCheckBox = new JCheckBox("Image");
        JCheckBox textCheckBox = new JCheckBox("Text");
        JCheckBox codeCheckBox = new JCheckBox("Code");
        JCheckBox appletCheckBox = new JCheckBox("Applet");

        panel.add(imageCheckBox);
        panel.add(textCheckBox);
        panel.add(codeCheckBox);
        panel.add(appletCheckBox);

        JRadioButton selectionButton = new JRadioButton("Selection");
        JRadioButton allButton = new JRadioButton("All");
        ButtonGroup group = new ButtonGroup();
        group.add(selectionButton);
        group.add(allButton);

        panel.add(selectionButton);
        panel.add(allButton);

        String[] qualities = {"High", "Medium", "Low"};
        JComboBox<String> qualityComboBox = new JComboBox<>(qualities);
        panel.add(new JLabel("Print Quality:"));
        panel.add(qualityComboBox);

        JCheckBox printToFileCheckBox = new JCheckBox("Print to File");
        panel.add(printToFileCheckBox);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        JButton setupButton = new JButton("Setup...");
        JButton helpButton = new JButton("Help");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(setupButton);
        buttonPanel.add(helpButton);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ex01();
    }
}
