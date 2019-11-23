// Ziyuan Cao
// CSE143 AB
// TA: Porter Jones
// Homework 3
// An AssassinManager allows a client to manage a game of assassin. It can
//     keeps track of who is stalking whom and the history of who killed whom.

import java.util.*;

public class AssassinManager {
    private AssassinNode killRingFront;
    private AssassinNode graveyardFront;

    // pre: given list, names, is not empty (throw an IllegalArgumentException
    //      if not)
    //      given list should not contain empty name, and with no duplicate
    //      name (case-insensitive) in it
    // post: constructs an AssassinManager with given names in the given list
    //       as players without changing the order
    public AssassinManager(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (int i = names.size() - 1; i >= 0; i--) {
            killRingFront = new AssassinNode(names.get(i), killRingFront);
        }
    }

    // post: prints the names of people in the kill ring, one per line,
    //       intended four spaces, in the format of "<name> is stalking
    //       <name>", to the console. If there is only one living person,
    //       print in the form that the person is stalking themselves to
    //       the console.
    public void printKillRing() {
        AssassinNode current = killRingFront;
        while (current.next != null) {
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println("    " + current.name + " is stalking " + killRingFront.name);
    }

    // post: prints the names of people in the graveyard, one per line,
    //       intended four spaces, in the format of "<name> was killed
    //       by <name>", in reverse kill order, to the console. If there
    //       is no player in the graveyard, produce no output to the console.
    public void printGraveyard() {
        AssassinNode current = graveyardFront;
        while (current != null) {
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
        }
    }

    // post: returns whether or not the given name (case-insensitive) is in
    //       the current kill ring
    public boolean killRingContains(String name) {
        return contains(killRingFront, name);
    }

    // post: returns whether or not the given name (case-insensitive) is in
    //       the current graveyard
    public boolean graveyardContains(String name) {
        return contains(graveyardFront, name);
    }

    // post: returns whether or not the game is over. The game is over when
    //       there is only one person in the kill ring.
    public boolean gameOver() {
        return killRingFront.next == null;
    }

    // post: returns the name of the winner of the game. If the game is not
    //       over, returns null.
    public String winner() {
        if (gameOver()) {
            return killRingFront.name;
        } else {
            return null;
        }
    }

    // pre: 1) the current kill ring contains the given name (throw an
    //      IllegalArgumentException if not)
    //      2) the game is not over (throw an IllegalStateException if not)
    // post: records the killing of the person with the given name
    //       (case-insensitive), transferring the person from the kill
    //       ring to the graveyard
    public void kill(String name) {
        if (!killRingContains(name)) {
            throw new IllegalArgumentException();
        } else if (gameOver()) {
            throw new IllegalStateException();
        }
        // initialize the assassin and the killed
        AssassinNode assassin = killRingFront;
        AssassinNode killed;
        if (killRingFront.name.equalsIgnoreCase(name)) { // front is the target
            killed = killRingFront;
            // go to the next in the kill ring until reaching the end and
            //     assign the ending node as the assassin
            while (assassin.next != null) {
                assassin = assassin.next;
            }
            killRingFront = killRingFront.next; // remove the killed
        } else { // killed person is at middle or end of the kill ring

            // go to the next in the kill ring until reaching the person one
            //     preceding the killed and assign that node as the assassin
            while (!assassin.next.name.equalsIgnoreCase(name)) {
                assassin = assassin.next;
            }
            killed = assassin.next;
            assassin.next = assassin.next.next; // remove the killed
        }
        // transfer the killed person to the graveyard and record the
        //     killer's name
        killed.killer = assassin.name;
        killed.next = graveyardFront;
        graveyardFront = killed;
    }

    // post: return whether or not the given name (case-insensitive) is in
    //       the linked list specified by the given front
    private boolean contains(AssassinNode front, String name) {
        while (front != null) {
            if (front.name.equalsIgnoreCase(name)) {
                return true;
            }
            front = front.next;
        }
        return false;
    }
}
