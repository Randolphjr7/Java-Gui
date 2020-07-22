package gettingGUI;

import javax.sound.midi.*;

// Version Two: Register and listen for the events, but without graphics
// Prints message @ command-line with each beat
public class MinMusicPlayer2 implements ControllerEventListener {

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

    void go() {

        try {
            // make and open a sequencer
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            // Register for events with the sequencer. The event registration method takes the listener AND an int
            // array representing the list of ControllerEvents you want. We want only one event, #127
            int[] eventsIwant = {127};
            sequencer.addControllerEventListener(this, eventsIwant);

            Sequence seq = new Sequence(Sequence.PPQ, 4); // make a sequence (different from a sequencer/player
            Track track = seq.createTrack(); // make a track

            // make a bunch of events to make notes
            for(int i = 5; i < 61; i+= 4) {
                // calling static utilty method
                track.add(makeEvent(144, 1, i, 100, i));

                // How we pick up the beat; we insert our OWN ControllerEvent(178 says the event type is
                // ControllerEvent) with an argument for event #127/ THis event will do NOTHING. We put
                // it in just so that we can get an event each time a note is played
                track.add(makeEvent(176, 1, 127, 100, i));

                // calling static utilty method
                track.add(makeEvent(144, 1, i, 100, i + 2));
            } // end loop

            // start running
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception e) {
            System.out.println("Error attempting to make sequencer: " + e);
        }
    }

    // The event handler method (from the ControllerEventListener interface) Each time we get the event, we print
    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("laLa");
    }

    public static void main(String[] args) {
        MinMusicPlayer2 min = new MinMusicPlayer2();
        min.go();
    }
}
