import java.awt.*;
import java.awt.event.*;

public class CreateFrame {
    Frame my_frame;

    public CreateFrame() {
        my_frame = new Frame("Babaero ba si Irwen?");
        my_frame.setLayout(new GridLayout(2, 1));
        my_frame.setSize(500, 400);

        my_frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                my_frame.dispose(); 
            }
        });

        my_frame.add(new Button("Oo naman yes"));
        my_frame.add(new Button("No (feeling ko mali to)"));

        my_frame.setVisible(true); 
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new CreateFrame();
        });
    }
}