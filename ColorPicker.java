import java.awt.*;
import java.awt.event.*;

public class ColorPicker extends Frame implements ItemListener {
    Choice colorChoice;

    ColorPicker() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        colorChoice = new Choice();
        colorChoice.add("Red");
        colorChoice.add("Green");
        colorChoice.add("Blue");
        colorChoice.add("Yellow");
        colorChoice.add("Cyan");
        colorChoice.add("Magenta");
        colorChoice.add("Black");
        colorChoice.add("White");
        colorChoice.add("Maroon");

        colorChoice.setFont(new Font("Arial", Font.PLAIN, 16));
        colorChoice.setPreferredSize(new Dimension(150, 30));
        colorChoice.addItemListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 20, 20, 20);

        add(colorChoice, gbc);

        setSize(400, 300);
        setTitle("Color Picker");
        setVisible(true);
        setResizable(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void itemStateChanged(ItemEvent e) {
        String selectedColor = colorChoice.getSelectedItem();
        switch (selectedColor) {
            case "Red":
                setBackground(Color.RED);
                break;
            case "Green":
                setBackground(Color.GREEN);
                break;
            case "Blue":
                setBackground(Color.BLUE);
                break;
            case "Yellow":
                setBackground(Color.YELLOW);
                break;
            case "Cyan":
                setBackground(Color.CYAN);
                break;
            case "Magenta":
                setBackground(Color.MAGENTA);
                break;
            case "Black":
                setBackground(Color.BLACK);
                break;
            case "White":
                setBackground(Color.WHITE);
                break;
            case "Maroon":
                setBackground(new Color(128, 0, 0));
                break;
        }
    }

    public static void main(String[] args) {
        new ColorPicker();
    }
}