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
 * An exception thrown in the <CODE>Set</CODE> class to indicate that the
 * the team exceeds the allowed number in a team.
 */
public class FullTeamException extends Exception {

    /**
     * Default constructor for an <CODE>FullTeamException</CODE> that
     * passes a default string to the <CODE>Exception</CODE> class
     * constructor.
     *
     * <dt><b>Postcondition:</b><dd>
     *    The object is created and contains the default message.
     */
    public FullTeamException()
    {  //Default message
        super("There is no more room inside of the Team to store the " +
                "new Player object");
    }

    /**
     * Second constructor for the <CODE>FullTeamException</CODE> that
     * passes a provided string to the <CODE>Exception</CODE> class
     * constructor.
     *
     * @param message
     *    the message that the object is to contain
     * <dt><b>Postcondition:</b><dd>
     *    The object is created and contains the provided message.
     */
    public FullTeamException(String message)
    {   //Passed message
        super(message);
    }
}