package TermProject;
import javax.swing.JFrame;

public class Driver {
    public static void main(String[] args) {
        Window window = new Window(); 
        JFrame frame = new JFrame("First to 33");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(window); 
        frame.pack();
        frame.setVisible(true);
    }
}