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

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class manages the different teams and also holds the while
 * loop that runs the whole simulation. You can choose to add a
 * Player, get a Player's stats, get a leader in a stat, remove
 * a player, print all the players, get the size of team, select
 * team a different team to modify, clone a team, see if a Team
 * equals another team, update a Player's stat, or quit.
 */
public class TeamManager {
    public static final int MAX_TEAMS = 5;
    private static Team[] teams = new Team[MAX_TEAMS];
    private static int currentTeam = 0;
    private static Player[] players = new Player[40];

    /**
     * Creates 5 Team objects to hold in the TeamManager
     */
    public TeamManager() {
        for (int i = 0; i < MAX_TEAMS; i++) {
            this.teams[i] = new Team();
        }
    }

    /**
     * Creates a constructor that has an argument: Team array
     * @param teams the Team array
     */
    public TeamManager(Team[] teams) {
        TeamManager.teams = teams;

    }

    /**
     * A getter method that gets a Team array
     * @return a Team array
     */
    public static Team[] getTeams() {
        return teams;
    }

    /**
     * This is the while loop where everything is run.
     * You can add a Player, get a Player's stats,
     * get a leader in a stat, remove a Player, print all
     * Players, get the size of a team, select a Team,
     * clone a Team, see if a Team equals another Team,
     * update a Player's stats, and quit
     *
     * @param args teams is a Team array
     *             pos is an int of the position
     * @throws IllegalArgumentException   Thrown if an
     *                                    invalid position
     *                                    is entered or
     *                                    if an invalid input
     *                                    is entered
     * @throws CloneNotSupportedException Thrown if the clone
     *                                    method in class Object
     *                                    has been called to
     *                                    clone an object, but
     *                                    the object's class
     *                                    does not implement
     *                                    the Cloneable
     *                                    interface.
     */
    public static void main(String[] args) throws
            IllegalArgumentException, CloneNotSupportedException,
            FullTeamException {
        Scanner scanner = new Scanner(System.in);
        TeamManager tm = new TeamManager();
        System.out.println("Welcome to TeamManager!\n" +
                "\nTeam 1 is currently selected.");
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Please select an option:\n" +
                        "A)  Add Player.\n" +
                        "G)  Get Player stats.\n" +
                        "L)  Get leader in a stat.\n" +
                        "R)  Remove a player.\n" +
                        "P)  Print all players.\n" +
                        "S)  Size of team.\n" +
                        "T)  Select team\n" +
                        "C)  Clone team\n" +
                        "E)  Team equals\n" +
                        "U)  Update stat.\n" +
                        "Q)  Quit.");
                System.out.print("Select a menu option: ");

                String s = scanner.nextLine();
                if (s.equalsIgnoreCase("q")) {
                    flag = false;
                }
                switch (s.toUpperCase()) {
                    case "A":
                        System.out.println();
                        Player p1 = new Player();

                        System.out.print("Enter the player's name: ");
                        String n = scanner.nextLine();

                        System.out.print("Enter the number of hits: ");
                        int h = scanner.nextInt();

                        System.out.print("Enter the number of errors: ");
                        int err = scanner.nextInt();

                        System.out.print("Enter the position: ");
                        int p = scanner.nextInt();
                        p -= 1;
                        scanner.nextLine();
                        if (p < players.length && players[p] != null) {
                            System.out.println("Invalid position for " +
                                    "adding the new player.");
                        } else if ((p + 1) >
                                (teams[currentTeam].getPlayerCount() + 1)) {
                            System.out.println("Invalid position for adding" +
                                    " the new player.");
                        } else {
                            System.out.println("Player added: " + n +
                                    " - " + h + " hits,  " + err +
                                    " errors");
                            p1.setName(n);
                            p1.setNumHits(h);
                            p1.setNumErrors(err);
                            teams[currentTeam].addPlayer(p1, p);
                            System.out.println();
                        }
                        break;

                    case "G":
                        System.out.print("Enter the position: ");
                        int positionT = scanner.nextInt();
                        positionT -= 1;
                        scanner.nextLine();
                        System.out.println(
                                teams[currentTeam].getPlayer(positionT));
                        break;

                    case "L":
                        System.out.print("Enter the stat: ");

                        String statistic = scanner.nextLine();
                        if (statistic.equalsIgnoreCase("hits")) {
                            System.out.println("Leader " +
                                    "in hits: " +
                                    teams[currentTeam].getLeader("hits")
                            );
                        } else if
                        (statistic.equalsIgnoreCase("errors")) {
                            System.out.println("Leader " +
                                    "in errors: "
                                    + teams[currentTeam].
                                    getLeader("errors"));
                        } else {
                            System.out.println("No such statistic.");
                        }
                        break;
                    case "R":
                        System.out.print("Enter the position: ");
                        int pos = scanner.nextInt();
                        pos -= 1;
                        scanner.nextLine();
                        if (teams[currentTeam].getPlayer(pos) == null) {
                            System.out.println("No player at position "
                                    + (pos + 1) + " to remove.");
                        } else {
                            System.out.println("Player Removed at position "
                                    + (pos + 1));
                            System.out.println(
                                    teams[currentTeam].getPlayer(pos).getName()
                                            + " has been removed from " +
                                            "the team.");
                            teams[currentTeam].removePlayer(pos);
                        }
                        break;
                    case "P":
                        System.out.print("Select team index: ");
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        teams[index - 1].printAllPlayers();
                        break;
                    case "S":
                        System.out.println("There " +
                                "are " + teams[currentTeam].size() +
                                " players(s) in the current Team.");
                        break;
                    case "T":
                        System.out.print("Enter team index to select: ");
                        int i = scanner.nextInt();
                        i -= 1;
                        scanner.nextLine();
                        if (i > 5) {
                            System.out.println("Invalid index for team.");
                            break;
                        } else {
                            System.out.println("Team " + (i + 1)
                                    + " has been selected.");
                            currentTeam = i;
                        }
                        break;
                    case "C":
                        int cloneFrom = 0;
                        int cloneTo = 0;
                        System.out.print("Select team to clone from: ");
                        cloneFrom = scanner.nextInt();
                        cloneFrom -= 1;
                        System.out.print("Select team to clone to: ");
                        cloneTo = scanner.nextInt();
                        cloneTo -= 1;
                        scanner.nextLine();
                        teams[cloneTo] = (Team) teams[cloneFrom].clone();
                        System.out.println("Team " + (cloneFrom + 1)
                                + " has " +
                                "been copied to team " + (cloneTo + 1));
                        break;
                    case "E":
                        System.out.print("Select first team index: ");
                        int fi = scanner.nextInt();
                        fi -= 1;
                        System.out.print("Select second team index: ");
                        int si = scanner.nextInt();
                        si -= 1;
                        scanner.nextLine();
                        if (teams[fi].equals(teams[si])) {
                            System.out.println("These teams are equal.");
                            break;
                        } else {
                            System.out.println("These teams are not equal.");
                            break;
                        }
                    case "U":
                        System.out.print("Enter the player to update: ");
                        String nameOf = scanner.nextLine();
                        System.out.print("Enter stat to update: ");
                        String st = scanner.nextLine();

                        System.out.print("Enter the new number of "
                                + st + ": ");
                        int new1 = scanner.nextInt();
                        scanner.nextLine();
                        boolean found = false;
                        for (int j = 0; j < teams[currentTeam].size(); j++) {
                            if
                            (teams[currentTeam].getPlayer(j).getName()
                                    .equalsIgnoreCase(nameOf)) {
                                found = true;
                                if (st.equalsIgnoreCase("errors")) {
                                    teams[currentTeam].getPlayer(j)
                                            .setNumErrors(new1);
                                    System.out.println("Updated " + nameOf
                                            + "'s " + st);
                                } else if
                                (st.equalsIgnoreCase("hits")) {
                                    teams[currentTeam].getPlayer(j)
                                            .setNumHits(new1);
                                    System.out.println("Updated " + nameOf
                                            + "'s " + st);
                                } else {
                                    throw new
                                            IllegalArgumentException
                                            ("Enter hits or errors");
                                }
                            }
                        }
                        if (!found) {
                            System.out.println("Player not found. ");
                        }
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid input.");
            }
        }
    }
}
