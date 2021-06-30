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
 * position is not within the valid range.
 */
public class IllegalArgumentException extends Exception {

    /**
     * Default constructor for an <CODE>IllegalArgumentException</CODE>
     * that passes a default string to the <CODE>Exception</CODE> class
     * constructor.
     *
     * <dt><b>Postcondition:</b><dd>
     *    The object is created and contains the default message.
     */
    public IllegalArgumentException()
    {  //Default message
        super("The position is not within the valid range.");
    }

    /**
     * Second constructor for the <CODE>IllegalArgumentException</CODE>
     * that passes a provided string to the <CODE>Exception</CODE> class
     * constructor.
     *
     * @param message
     *    the message that the object is to contain
     * <dt><b>Postcondition:</b><dd>
     *    The object is created and contains the provided message.
     */
    public IllegalArgumentException(String message)
    {   //Passed message
        super(message);
    }
}
