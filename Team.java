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
 * This class creates a Team. It has a player count, gets the Player
 * array, has a clone Team method, a .equals method, a size method
 * that simply returns the player count, an add player method, a
 * remove player method, a get Player method, a get Leader in a
 * statistic method, a print all players method, a players toString
 * method, and a toString method.
 */
public class Team implements Cloneable {

    public static final int MAX_PLAYERS = 40;
    private int playerCount = 0;
    private Player[] players;

    /**
     * Gets the number of players
     *
     * @return an int of the number of players
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * Returns an array of players
     *
     * @return an array of Players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Brief:
     * Construct an instance of the Team class with no Player objects in it.
     * Postconditions:
     * This Team has been initialized to an empty list of Players.
     */
    public Team() {
        players = new Player[MAX_PLAYERS];
    }

    /**
     * Brief:
     * Generates a clone of this Team.
     * Subsequent changes to the clone
     * will not affect the original, nor vice versa.
     * Note that the return value must
     * be typecast to a Team before it can be used.
     *
     * @return a clone of this Team
     * @throws CloneNotSupportedException Thrown if the
     *         clone method in class Object has been
     *         called to clone an object, but the the object's
     *         class does not implement the Cloneable interface.
     */
    public Object clone() throws CloneNotSupportedException {
        Team cloned = new Team();
        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] == null) {
                break;
            }
            try {
                Player p = new Player();
                p.setName(players[i].getName());
                p.setNumHits(players[i].getNumHits());
                p.setNumErrors(players[i].getNumErrors());
                cloned.addPlayer(p, i);
            } catch (IllegalArgumentException | FullTeamException e) {
                continue;
            }
        }
        return cloned;
    }

    /**
     * Brief:
     * Compares this Team to another object for equality.
     *
     * @param obj an object to which this Team is compared
     * @return A return value of true indicates that obj refers to a
     * Team object with the same Players in the same order as
     * this Team. Otherwise, the return value is false. If obj
     * is null or it is not a Team object, then the return value is false.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Team) {
            Team t = (Team) obj;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Team t = (Team) obj;
        boolean a = true;
        for (int i = 0; i < players.length; i++) {
            if (this.players[i] == null) {
                break;
            }
            if (this.players[i].equals(t.getPlayers()[i])) {
            } else {
                return !a;
            }
        }
        return playerCount == ((Team) obj).getPlayerCount();
    }

    /**
     * Brief:
     * Determines the number of Players currently in this Team.
     * Preconditions:
     * This Team object has been instantiated.
     *
     * @return an integer number of Players in this Team.
     */
    public int size() {
        return playerCount;
    }

    /**
     * Brief:
     * Adds a Player to the team at the indicated position in the lineup.
     * Preconditions:
     * This Team object has been instantiated
     * 1 ≤ position ≤ players_currently_in_team + 1.
     * The number of Player objects in this Team is less than MAX_PLAYERS.
     * Postconditions:
     * The new Player is now stored at the desired position in the Team.
     * All Players that were originally in positions greater than or equal
     * to position are moved back one position.
     * E.g. If there are 5 Players in a Team, positions 1-5, and you insert
     * a new Player at position 4, the new Player will now be at position 4,
     * the Player that was at position 4 will be moved to position 5, and the
     * Player that was at position 5 will be moved to position 6).
     *
     * @param p        the new Player object to add to this Team.
     * @param position the position in the lineup where the Player will be
     *                 inserted
     * @throws IllegalArgumentException When that position is not within
     *                                  the valid range.
     * @throws FullTeamException        When there is no more room inside
     *                                  of the Team to store the new Player
     *                                  object.
     */
    public void addPlayer(Player p, int position)
            throws IllegalArgumentException, FullTeamException {
        if (position < 0) {
            throw new IllegalArgumentException("The position is not within" +
                    " the valid range.");
        }
        if (position > playerCount + 1) {
            System.out.println("Invalid position for adding the new player.");
        }
        if (playerCount >= 40) {
            throw new FullTeamException("There is no more room inside of " +
                    "the Team to store the new Player object");
        }
        for (int i = players.length - 1; i > position; i--) {
            players[i] = players[i - 1];
        }
        this.players[position] = p;
        playerCount++;
    }

    /**
     * Brief:
     * Removes a Player from the team at the indicated position in the lineup.
     * Preconditions:
     * This Team object has been instantiated
     * 1 ≤ position ≤ players_currently_in_team + 1.
     * Postconditions:
     * The Player at the desired position in the Team has been removed.
     * All Players that were originally in positions greater than or equal to
     * position are moved forward one position.
     * E.g. If there are 5 Players in a Team, positions 1-5, and you remove
     * the Player at position 4, the Player that was at position 5 will be
     * moved to position 4.
     *
     * @param position the int position in the lineup from which the Player
     *                 is to be removed.
     * @throws IllegalArgumentException Thrown when a given position is not
     *                                  within the valid range.
     */
    public void removePlayer(int position) throws IllegalArgumentException {
        players[position] = null;
        playerCount--;
        if (0 <= position && position <= playerCount) {
            for (int i = position; i < players.length - 1; i++) {
                players[i] = players[i + 1];
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Brief:
     * Returns a reference to a player in the lineup at the indicated position.
     * Preconditions:
     * This Team object has been instantiated.
     *
     * @param position the int position in the lineup from which the Player
     *                 is to be retrieved.
     * @return The Player from the given index.
     * @throws IllegalArgumentException Thrown when the given position is
     * not within the valid range.
     */
    public Player getPlayer(int position) throws IllegalArgumentException {
        if (position < players.length)
            return players[position];
        else
            throw new IllegalArgumentException();
    }

    /**
     * Brief:
     * Return the Player with the best value in the given statistic
     * ("hits" or "errors").
     * Preconditions:
     * This Team object has been instantiated.
     * @param stat a String named either "hits" or "errors".
     * @return The Player with the best stat.
     * @throws IllegalArgumentException Thrown when the indicated
     *                                  stat was neither "hits"
     *                                  nor "errors".
     */
    public Player getLeader(String stat) throws IllegalArgumentException {
        int best;
        Player best1 = players[0];
        ;

        if (stat.equalsIgnoreCase("hits")) {
            best = players[0].getNumHits();

            for (int i = 0; i < playerCount; i++) {
                if (players[i].getNumHits() > best) {
                    best = players[i].getNumHits();
                    best1 = players[i];
                }
            }
        } else if (stat.equalsIgnoreCase("errors")) {
            for (int i = 0; i < playerCount; i++) {
                best = players[0].getNumErrors();
                best1 = players[0];
                if (players[i].getNumErrors() < best) {
                    best = players[i].getNumErrors();
                    best1 = players[i];
                }
            }
        } else {
            throw new IllegalArgumentException("the indicated stat was " +
                    "neither \"hits\" nor \"errors\"");
        }
        return best1;
    }

    /**
     * @returns a String with the Player number, name, hits, and errors
     */
    public String toString() {
        return playersToString(players);
    }

    /**
     * Brief:
     * Prints a neatly formatted table of each Player in the Team on its
     * own line with its position number as shown in the sample output.
     * Preconditions:
     * This Team object has been instantiated.
     * Postconditions:
     * A neatly formatted table of each Player in the Team on its own
     * line with its position number has been displayed to the user.
     */
    public void printAllPlayers() {
        playersToString(players);
    }

    /**
     * This method takes in a Player[] and specifies a string header to
     * use when printing out the players. It automatically puts spaces
     * between the players' positions, names, number of hits, and number
     * of errors.
     * @param players is a Player[].
     * @return a properly formatted player list with each player on its
     * own line and with spaces between the players' attributes.
     */
    public String playersToString(Player[] players) {
        String temp = "";
        System.out.println("Player#       Name                    " +
                "Hits       Errors" +
                "\n-------------------------------------------------------");
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                continue;
            }
            String name = players[i].getName();
            int hits = players[i].getNumHits();
            int errors = players[i].getNumErrors();
            temp += System.out.printf("%-14d%-24s%-9d%4d\n", (i + 1),
                    name, hits, errors);
        }
        return temp;
    }
}
