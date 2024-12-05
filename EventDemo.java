import java.awt.*;
import java.awt.event.*;

public class EventDemo extends Frame implements ActionListener, ItemListener, WindowListener, KeyListener, MouseListener, MouseMotionListener {

    // Components
    private TextField textField;
    private Button button;
    private Checkbox checkbox;
    private List list;
    private Label label;
    private MenuBar menuBar;
    private Menu fileMenu;
    private MenuItem exitItem;
    private MenuItem openItem;

    public EventDemo() {
        super("Event Demo");
        setLayout(new FlowLayout());

        // Text Field
        textField = new TextField(20);
        add(textField);

        // Button
        button = new Button("Click Me");
        button.addActionListener(this);
        add(button);

        // Checkbox
        checkbox = new Checkbox("Check Me", true);
        checkbox.addItemListener(this);
        add(checkbox);

        // List
        list = new List(10, false); // Set the visible item count to 10
        // Adding more items to the list
        for (int i = 1; i <= 20; i++) {
            list.add("Item " + i);
        }
        add(list);

        // Label
        label = new Label("Status: ");
        add(label);

        // Menu Bar
        menuBar = new MenuBar();
        setMenuBar(menuBar);

        // File Menu
        fileMenu = new Menu("File");
        menuBar.add(fileMenu);

        // Exit Item
        exitItem = new MenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);

        // Open Item
        openItem = new MenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        // Add Window Listener
        addWindowListener(this);
        addKeyListener(this); // Add KeyListener
        addMouseListener(this); // Add MouseListener
        addMouseMotionListener(this); // Add MouseMotionListener

        setSize(400, 300);
        setVisible(true);
    }

    // ActionListener Implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            label.setText("Button clicked!");
        } else if (e.getSource() == exitItem) {
            System.exit(0);
        } else if (e.getSource() == openItem) {
            label.setText("Open action triggered!");
        }
    }

    // ItemListener Implementation
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == checkbox) {
            label.setText("Checkbox state changed: " + (checkbox.getState() ? "Checked" : "Unchecked"));
        }
    }

    // WindowListener Implementation
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    // KeyListener Implementation
    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        label.setText("Key Pressed: " + keyChar);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        label.setText("Mouse at: " + point);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    // MouseListener Implementation
    @Override
    public void mouseClicked(MouseEvent e) {
        label.setText("Mouse Clicked at: " + e.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    // MouseMotionListener Implementation
    @Override
    public void mouseDragged(MouseEvent e) {
        label.setText("Mouse Dragged at: " + e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        label.setText("Mouse Moved at: " + e.getPoint());
    }

    public static void main(String[] args) {
        new EventDemo();
    }
}