package gettingGUI;

import javax.sound.midi.*;

// Version One: Code that simplifies making and adding MIDI events.
public class MinMusicPlayer1 {

    // static utility method that makes a message and returns a MidiEvent
    static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            System.out.println("Error trying to make MidiEvent: " + e);
        }
        return event;
    }

    public static void main(String[] args) {

        try {
            // make and open a sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            Sequence seq = new Sequence(Sequence.PPQ, 4); // make a sequence (different from a sequencer/player
            Track  track = seq.createTrack(); // make a track
            // make a bunch of events to make notes
            for(int i = 5; i < 61; i+= 4) {
                // calling static utilty method
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(144, 1, i, 100, i + 3));
            } // end loop

            // start running
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            System.out.println("Error attempting to make sequencer: " + e);
        }
    }
}
