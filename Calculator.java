import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    private TextField inputField;
    private String operator;
    private double firstNumber;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        inputField = new TextField();
        inputField.setEditable(false);
        inputField.setFont(new Font("Arial", Font.BOLD, 24));
        add(inputField, BorderLayout.NORTH);

        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLACK);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("C".equals(command)) {
            inputField.setText("");
            operator = null;
            firstNumber = 0;
        } else if ("=".equals(command)) {
            double secondNumber = Double.parseDouble(inputField.getText());
            double result = performOperation(firstNumber, secondNumber, operator);
            inputField.setText(String.valueOf(result));
            operator = null;
        } else if ("+".equals(command) || "-".equals(command) || "*".equals(command) || "/".equals(command)) {
            firstNumber = Double.parseDouble(inputField.getText());
            operator = command;
            inputField.setText("");
        } else {
            inputField.setText(inputField.getText() + command);
        }
    }

    private double performOperation(double firstNumber, double secondNumber, String operator) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return secondNumber != 0 ? firstNumber / secondNumber : 0;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}