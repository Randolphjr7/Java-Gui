package gettingGUI;

public class SimpleGui1 {

    public static String longestCommonPrefix(String[] strs) {


        String test = "testing";
        char[] hmm  = test.toCharArray();
        for(char c: hmm) {
            System.out.println(c);
        }

        for(String letter: strs) {


            char[] result = letter.toCharArray();
            
        }

        return "Help";
    }


    public static void main(String[] args) {


        String [] test = {"flower","flow","flight"};

        longestCommonPrefix(test);



        // make a frame and button
 /*       JFrame frame = new JFrame();
        JButton button = new JButton("Click Me");

        // make the program quit as soon as you close the window.
        // Without this it will sit there forever
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add button to the frame
        frame.getContentPane().add(button);
        // size the frame in pixels
        frame.setSize(300, 300);
        // make it visible
        frame.setVisible(true);*/

    }
}
