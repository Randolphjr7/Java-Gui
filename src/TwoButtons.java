import gettingGUI.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class TwoButtons {

    JFrame frame;
    JLabel label;

    void go() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener()); // make in instance of inner class and register with
                                                            // event source object

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(400,300);
        frame.setVisible(true);

    }


    class LabelListener implements ActionListener {
        int min = 0;
        int max = 2;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

        String[] names = {"Baldwin", "Thompson", "Christopher"};

        @Override
        public void actionPerformed(ActionEvent event) {
            label.setText(names[randomNum]); // inner class can use all outer class methods and variables
        }
    } // end of inner class LabelListener

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();
        }
    } // end of inner class ColorListener

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();

/*        int min = 0;
        int max = 2;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("random number: " + randomNum);*/
    }
}
