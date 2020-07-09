package gettingGUI;

import javax.swing.*;
import java.awt.*;

// make a subclass of Jpanel, a widget that you can add to a frame just
// like anything else, except this one is your own customized widget
public class MyDrawPanel extends JPanel {

    /* You have to override the paintComponent() method*/

    // draw a widget
/*    public void paintComponent(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(20, 50, 100, 100);
    }*/

    // display a JPEG
/*    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("ali.jpg").getImage();
        g.drawImage(image, 3,4, this);
    }*/

    // paint a random colored circle on a black background
/*    public void paintComponent(Graphics g) {
        // fill the entire panel with black. The default color
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int red   = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue  = (int) (Math.random() * 256);

        // you can make a color by passing in 3 ints to represent RGB
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }*/


    /* The object referenced by the "g" parameter is actually an instance of the Graphics2D Class
    *  and since there are more methods you can call on a Graphics2D reference and more importantly
    *  the compiler WILL ONLY SEE a Graphics reference you will have to cast it with a new Graphics2D
    *  variable */
/*    public void paintComponent(Graphics g) {
        // casting to a Graphics2D variable
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
        // set the virtual paint brush to a gradient
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }*/


    // Same as above except this method makes random colors to fill the gradient
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // random colors
        int red   = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue  = (int) (Math.random() * 256);

        Color startColor = new Color(red, green, blue);

        red   = (int) (Math.random() * 256);
        green = (int) (Math.random() * 256);
        blue  = (int) (Math.random() * 256);

        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);

    }

}
