package gettingGUI.music;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

// the drawing panel is a listener
public class MyDrawPanel extends JPanel implements ControllerEventListener {
    // set the flag to true only when we get an event
    boolean msg = true;

    @Override
    public void controlChange(ShortMessage shortMessage) {
        // when we get an event, set flag to true & repaint
        msg = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        // paint only if we receive a Controller event (shortMessage)
        if(msg) {
            // casting
            Graphics2D g2 = (Graphics2D) g;
            // generate random colors
            int red   = (int) (Math.random() * 250);
            int green = (int) (Math.random() * 250);
            int blue  = (int) (Math.random() * 250);

            g.setColor(new Color(red, green, blue));
            // paint random sized rectangles
            int height = (int) ((Math.random() * 120) + 10);
            int width  = (int) ((Math.random() * 120) + 10);
            int x      = (int) ((Math.random() * 40)  + 10);
            int y      = (int) ((Math.random() * 40)  + 10);
            g.fillRect(x, y, width, height);
            msg = false;
        } // close if
    } // close method
} // close inner class
