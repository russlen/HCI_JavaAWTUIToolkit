import java.awt.*;
import java.awt.event.*;

public class AWTEventExample extends Frame implements MouseListener, MouseMotionListener, FocusListener, KeyListener {
   public AWTEventExample() {
       super("AWT Event Example");
       setSize(500, 400);
       setLayout(null);
       addMouseListener(this);
       addMouseMotionListener(this);
       addFocusListener(this);
       addKeyListener(this);
       setVisible(true);
   }

   @Override
   public void mouseClicked(MouseEvent e) {
       System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
   }

   @Override
   public void mousePressed(MouseEvent e) {
       System.out.println("Mouse pressed at: " + e.getX() + ", " + e.getY());
   }

   @Override
   public void mouseReleased(MouseEvent e) {
       System.out.println("Mouse released at: " + e.getX() + ", " + e.getY());
   }

   @Override
   public void mouseEntered(MouseEvent e) {
       System.out.println("Mouse entered the frame.");
   }

   @Override
   public void mouseExited(MouseEvent e) {
       System.out.println("Mouse exited the frame.");
   }

   @Override
   public void mouseDragged(MouseEvent e) {
       System.out.println("Mouse dragged at: " + e.getX() + ", " + e.getY());
   }

   @Override
   public void mouseMoved(MouseEvent e) {
       System.out.println("Mouse moved at: " + e.getX() + ", " + e.getY());
   }

   @Override
   public void focusGained(FocusEvent e) {
       System.out.println("Frame gained focus.");
   }

   @Override
   public void focusLost(FocusEvent e) {
       System.out.println("Frame lost focus.");
   }

   @Override
   public void keyTyped(KeyEvent e) {
       System.out.println("Key typed: " + e.getKeyChar());
   }

   @Override
   public void keyPressed(KeyEvent e) {
       System.out.println("Key pressed: " + e.getKeyCode());
   }

   @Override
   public void keyReleased(KeyEvent e) {
       System.out.println("Key released: " + e.getKeyCode());
   }

   public static void main(String[] args) {
       AWTEventExample example = new AWTEventExample();
       example.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent we) {
               System.exit(0);
           }
       });
   }
}