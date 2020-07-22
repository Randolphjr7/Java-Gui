package gettingGUI.music;

import javax.sound.midi.*;
import javax.swing.*;

public class MiniMusicPlayer3 {

    static JFrame f = new JFrame("Music Video"); // to make a GUI, start with a window
    static MyDrawPanel ml; // subclass of JPanel a widget that you add to the window

    void setUpGui() {
        ml = new MyDrawPanel(); // object-widget
        f.setContentPane(ml); // add obj-widget to the window pane
        // set size and make the window (JFrame) visible
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    } // close method

    void go() {
        setUpGui();

        try {
            // cd player
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[] {127});
            // make a sequence (musical piece that plays one song)
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track  = seq.createTrack();

            int r = 0;
            for(int i = 0; i < 60; i += 4) {

                r = (int) ((Math.random() * 50) + 1);
                track.add(makeEvent(144, 1, r, 100, i));
                track.add(makeEvent(176, 1, 127, 0, i));
                track.add(makeEvent(128, 1, r, 100, i + 2));
            } // end loop

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // close

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            System.out.println("Error!!! " + e);
        }
        return event;
    } // close event


    public static void main(String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    }
}
