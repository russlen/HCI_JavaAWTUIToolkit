import java.awt.*;
import java.awt.event.*;

public class MenuBarExample extends Frame {

    public MenuBarExample() {
        setTitle("AWT Menu Bar Example");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Create a label to display messages
        Label messageLabel = new Label("Select an option from the menu", Label.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        messageLabel.setForeground(Color.BLACK);
        
        // Use a Panel to hold the label and set its background
        Panel labelPanel = new Panel();
        labelPanel.setBackground(Color.LIGHT_GRAY);
        labelPanel.add(messageLabel);
        add(labelPanel, BorderLayout.NORTH);

        // Create a panel for buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Button 1 clicked");
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Button 2 clicked");
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Button 3 clicked");
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Button 4 clicked");
            }
        });

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        add(buttonPanel, BorderLayout.CENTER);

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");

        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("Open menu item clicked");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText("About menu item clicked");
            }
        });

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        setMenuBar(menuBar);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuBarExample();
    }
}