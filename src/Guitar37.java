// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework #2
// A Guitar37 represents a guitar with 37 strings. Each string has its own
//     pitch and a corresponding character on the keyboard. Client can play
//     certain note and get general information (eg. time and sample) about
//     Guitar37.

public class Guitar37 implements Guitar {

    public static final String KEYBOARD =
            "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // keyboard layout
    private GuitarString[] allGuitarString; // the 37 strings of Guitar37
    private int ticTime; // the number of times tic() has been called

    // post: Constructs a Guitar37 with 37 strings (each string has its
    //       own note on the chromatic scale)
    public Guitar37() {
        allGuitarString = new GuitarString[KEYBOARD.length()];
        for (int i = 0; i < allGuitarString.length; i++) {
            // assign GuitarString objects with frequency from 110Hz to 880Hz
            allGuitarString[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }
    }

    // post: Plays the string of a certain note specified by the given
    //       pitch if the note does exist on Guitar37. If it does not
    //       exist, do nothing.
    // parameter: pitch -- represent a note that want to be played
    public void playNote(int pitch) {
        if (pitch <= 12 && pitch >= -24) {
            allGuitarString[pitch + 24].pluck();
        }
    }

    // post: returns whether or not the given key has a corresponding string
    //       on Guitar37 (whether or not KEYBOARD contains the given key)
    public boolean hasString(char key) {
        return KEYBOARD.indexOf(key) != -1;
    }

    // pre: key is legal for Guitar37 (throw an IllegalArgumentException if not)
    // post: plays the corresponding string of the given key
    public void pluck(char key) {
        if (!hasString(key)) {
            throw new IllegalArgumentException();
        }
        allGuitarString[KEYBOARD.indexOf(key)].pluck();
    }

    // post: returns the sum of current samples from all the strings of Guitar37
    public double sample() {
        double sampleSum = 0.0;
        for (int i = 0; i < allGuitarString.length; i++) {
            sampleSum += allGuitarString[i].sample();
        }
        return sampleSum;
    }

    // post: advances the time of Guitar37 one tic forward
    public void tic() {
        for (int i = 0; i < allGuitarString.length; i++) {
            allGuitarString[i].tic();
        }
        ticTime++;
    }

    // post: returns the number of times of the tic() method has been called
    public int time() {
        return ticTime;
    }
}