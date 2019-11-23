// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework #2
// A GuitarString simulates a vibrating string of a guitar. It keeps track of
//     physical information of a string, such as displacement value, using the
//     model of a ring buffer.

import java.util.*;

public class GuitarString {

    public static final double ENERGY_DECAY_FACTOR = 0.996;

    // displacement at several points (in time) on a string
    private Queue<Double> ringBuffer;

    // pre: frequency > 0, (StdAudio.SAMPLE_RATE / frequency) >= 2 (throw a
    //      IllegalArgumentException if either condition is not satisfied)
    // post: constructs a GuitarString with given frequency and initialize the
    //       ring buffer as static state (all samples are zero).
    public GuitarString(double frequency) {
        int bufferCapacity = (int) Math.round(StdAudio.SAMPLE_RATE / frequency);
        if (frequency <= 0 || bufferCapacity < 2) {
            throw new IllegalArgumentException();
        }
        ringBuffer = new LinkedList<Double>();
        for (int i = 0; i < bufferCapacity; i++) {
            ringBuffer.add(0.0);
        }
    }

    // pre: the length of init should be greater than or equal to 2
    //      (throw an IllegalArgumentException if not)
    // post: constructs a GuitarString and initializes the ring buffer with
    //       the value in the given array
    // parameter: init --- initial information want to be put into the
    //            ring buffer
    public GuitarString(double[] init) {
        if (init.length < 2) {
            throw new IllegalArgumentException();
        }
        ringBuffer = new LinkedList<Double>();
        for (int i = 0; i < init.length; i++) {
            ringBuffer.add(init[i]);
        }
    }

    // post: simulates the excitation of the string by randomly assigning
    //       displacement value between -0.5 (inclusive) and +0.5 (exclusive)
    //       to the ring buffer
    public void pluck() {
        for (int i = 0; i < ringBuffer.size(); i++) {
            ringBuffer.remove();
            ringBuffer.add(Math.random() - 0.5);
        }
    }

    // post: simulates the vibration of the string once by applying the
    //       Karplus-Strong update on the ring buffer once
    public void tic() {
        double firstSample = ringBuffer.remove();
        double secondSample = ringBuffer.peek();
        ringBuffer.add((firstSample + secondSample) / 2 * ENERGY_DECAY_FACTOR);
    }

    // post: return the current (the front) sample on the ring buffer
    public double sample() {
        return ringBuffer.peek();
    }
}
