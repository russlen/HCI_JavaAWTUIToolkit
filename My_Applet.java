import java.awt.*;
import java.applet.*;

public class My_Applet extends Applet {
    private int cursorX = -1; // To store the cursor's X position
    private int cursorY = -1; // To store the cursor's Y position

    public void init() {
        // Initialization code here, if needed
    }

    public boolean mouseEnter(Event evt, int x, int y) {
        draw_object(x, y);
        return true;
    }

    public boolean mouseMove(Event evt, int x, int y) {
        cursorX = x; // Update cursor position
        cursorY = y; // Update cursor position
        repaint(); // Request to repaint the applet
        return true;
    }

    public void draw_object(int x, int y) {
        // You could implement any object drawing logic here.
        // For demonstration, we will just repaint the applet.
        Graphics g = getGraphics();
        g.setColor(Color.RED); // Set color for the object
        g.fillRect(x - 10, y - 10, 20, 20); // Draw a square at the mouse position
    }

    public void draw_cursor(int x, int y) {
        // This method can be used to draw the cursor. 
        // For simplicity, we will just repaint the cursor in the mouseMove method.
        Graphics g = getGraphics();
        g.setColor(Color.BLUE); // Set color for the cursor
        g.drawLine(x - 5, y, x + 5, y); // Draw a horizontal line for the cursor
        g.drawLine(x, y - 5, x, y + 5); // Draw a vertical line for the cursor
    }

    public void paint(Graphics g) {
        // This method is called whenever the applet is repainted.
        // Draw the cursor if the mouse has moved
        if (cursorX != -1 && cursorY != -1) {
            draw_cursor(cursorX, cursorY);
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("My Applet");
        My_Applet applet = new My_Applet();
        applet.init();
        frame.add(applet);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}