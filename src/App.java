import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private JPanel painel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button1;


    public App() {
        add(painel);
        setTitle("Compiler");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
