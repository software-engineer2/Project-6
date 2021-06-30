/*
Debamita Saha
SOLAR ID#: 112494564
debamita.saha@stonybrook.edu
Homework #1
Course: CSE 214
Recitation number: R04
TA's Name: James Finn
*/

package Homework1;

/**
 * This class creates a Player object with a name, a number of hits,
 * and a number of errors. There are getters and setters for each of
 * these. It has a .equals method and a toString method.
 */
public class Player {
    private String name;
    private int numHits;
    private int numErrors ;

    /**
     * Creating a Player constructor with a name, number of hits,
     * and number of errors
     */
    public Player() {
        name = "John";
        numHits = 0;
        numErrors = 0;
    }

    /**
     * Creates a new player object
     * @param name String of player's name
     * @param numHits int of player's number of hits
     * @param numErrors int of player's number of errors
     */
    public Player(String name, int numHits, int numErrors) {
        this.name = name;
        this.numHits = numHits;
        this.numErrors = numErrors;
    }

    /**
     * Gets the name of the player
     * @return String that has the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of hits from a player
     * @return an int number of hits of a player
     */
    public int getNumHits() {
        return numHits;
    }

    /**
     * Gets the number of errors from a player
     * @return an int number of errors of a player
     */
    public int getNumErrors() {
        return numErrors;
    }

    /**
     * A setter that sets the name of a player
     * @param name a String of the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A setter that sets the number of hits of a player
     * @param numHits an int of the player's number of hits
     * @throws IllegalArgumentException thrown when the new
     *                                  value of the numHits
     *                                  is less than 0
     */
    public void setNumHits(int numHits) throws IllegalArgumentException {
        this.numHits = numHits;
        if (numHits < 0)
            throw new IllegalArgumentException
                    ("new value of numHits is less than 0");
    }

    /**
     * A setter that sets the int number of errors that a player made
     * @param numErrors the int number of errors a player made
     * @throws IllegalArgumentException thrown when the new value of
     *                                  numErrors is less than 0
     */
    public void setNumErrors(int numErrors) throws IllegalArgumentException {
        this.numErrors = numErrors;
        if (numErrors < 0)
            throw new IllegalArgumentException("new value of numbErrors is" +
                    " less than 0");
    }

    /**
     * Compares this Player to another object for equality.
     * @param obj an object to which this Player is compared
     * @return A return value of true indicates that obj refers
     *         to a Player object with the same name, number of
     *         hits, and number of errors in the same order as
     *         this Player. Otherwise, the return value is false.
     *         If obj is null or it is not a Player object,
     *         then the return value is false.
     */
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Player p = (Player) obj;
        return name.equals(p.name) && numHits == p.numHits &&
                numErrors == p.numErrors;
    }

    /**
     * Formats the player's name, hits, and errors neatly
     * @return a String that formats the player's name, hits,
     *         and errors neatly
     */
    public String toString() {
        return name + " - " + numHits + " hits, " + numErrors + " errors";
    }
}