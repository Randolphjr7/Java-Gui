package gettingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui2 implements ActionListener {
    JFrame frame = new JFrame();
    JButton button;

    // button calls this event handling method
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // the event object passed to this method carries info about the source event
        // button.setText("Hello World!");
        frame.repaint();
    }

    void go() {

        button = new JButton("Change Colors");

        // register with button. The argument you pass must be an object from a class
        // that implements ActionListener. In this case SimpleGui does exactly that
        button.addActionListener(this);

        // make your own graphics my making a subclass of JPanel.
        MyDrawPanel drawPanel = new MyDrawPanel();

        // putting widgets on a frame
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    } // end go() method

/*    public static void main(String[] args) {
        SimpleGui2 test = new SimpleGui2();
        test.go();
    }*/
}
