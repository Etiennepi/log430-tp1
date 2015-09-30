package edu.gordon.common.exceptions;

/** Exception thrown when the user presses the cancel key while the ATM is
 *  waiting for some action
 */
@SuppressWarnings("serial")
public class Cancelled extends Exception
{
    /** Constructor
     */
    public Cancelled()
    {
        super("Cancelled by customer");
    }
}
