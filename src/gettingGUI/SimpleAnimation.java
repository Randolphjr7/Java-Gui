import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

    // instance variables that the inner class will have access to
    int x = 300;
    int y = 300;

    // inner class
    class MyDrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            // to erase and avoid trails/smears in the animation
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            // for the ball
            g.setColor(Color.orange);
            g.fillOval(x, y, 40, 40); // x and y are doable since MyDrawPanel is an inner class
        }

    }

    public void go() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        // animation action
        for(int i = 0; i < 400; i++) {
            //decrease x and y
            x--;
            y--;

            // repaint
            drawPanel.repaint();
            // frame.repaint(); // another way

            try {
                Thread.sleep(50); // slow it down....ball will move to fast
            } catch(Exception e) {
                System.out.println("Error + " + e);
            }
        }
    }


/*
    public static void main(String[] args) {
        SimpleAnimation test = new SimpleAnimation();
        test.go();
    }
*/

}
