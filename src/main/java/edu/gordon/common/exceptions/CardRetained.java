package edu.gordon.common.exceptions;

/** Exception that is thrown when the customer's card is retained due to too
 *  many invalid PIN entries
 */
@SuppressWarnings("serial")
public class CardRetained extends Exception
{
    /** Constructor
     */
    public CardRetained()
    {
        super("Card retained due to too many invalid PINs");
    }
}
