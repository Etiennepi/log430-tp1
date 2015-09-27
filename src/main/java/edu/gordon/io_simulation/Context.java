package edu.gordon.io_simulation;

import edu.gordon.bank_simulation.Balances;
import edu.gordon.common.Card;
import edu.gordon.bank_proxy.Message;
import edu.gordon.common.Money;
import edu.gordon.bank_simulation.Status;

/** Representation of the context in which the system operates. A child of this class must
 * supply high level functions for the ATM, like "readCard()".
 */

public abstract class Context
{
	/** Getting initial amount of cash from operator
    *
    *  @return value of initial cash entered
    */
   public abstract Money getInitialCash();

   /** Reading of a card
   *
   *  @return Card object representing information on the card if read
   *          successfully, null if not read successfully
   */
   public abstract Card readCard();

   /** Ejecting a card
    */
   public abstract void ejectCard();

   /** Retaining a card
    */
   public abstract void retainCard();

   /** Clear the simulated display
    */
   public abstract void clearDisplay();

   /** Write one or more lines to the display - beginning just after the
    *  last line written
    *
    *  @param text the text to display
    */
   public abstract void display(String text);

   /** Reading input from the keyboard
    *
    *  @param mode the input mode to use - one of the constants defined below.
    *  @param maxValue the maximum acceptable value (used in MENU_MODE only)
    *  @return the line that was entered - null if user pressed CANCEL.
    */
   public abstract String readInput(int mode, int maxValue);

   /** Dispensing cash to a customer
    *
    *  @param amount the amount of cash to dispense
    *
    *  Precondition: amount is lower than cash on hand
    */
   public abstract void dispenseCash(Money amount);

   /** Accepting an envelope from customer.
    *
    *  return true if an envelope was received within the prescribed time,
    *         else false
    */
   public abstract boolean acceptEnvelope();

   /** Printing one line of a receipt
    *
    *  @param text the line to print
    */
   public abstract void printReceiptLine(String text);

   /** Printing a line to the log
    *
    *  @param text the line to print
    */
   public abstract void printLogLine(String text);

   /** Sending a message to bank
    *
    *  @param message the message to send
    *  @param balances (out) balances in customer's account as reported
    *         by bank
    *  @return status code returned by bank
    */
   public abstract Status sendMessage(Message message, Balances balances);

   /** Notify the ATM that the state of the on-off switch has been changed
    *
    *  @param on true if state is now "on", false if it is "off"
    */
   public abstract void switchChanged(boolean on);

   /* Possible values for mode parameter to readInput() */
   
   /** Read input in PIN mode - allow user to enter several characters,
    *  and to clear the line if the user wishes; echo as asterisks
    */
   public static final int PIN_MODE = 1;
   
   /** Read input in amount mode - allow user to enter several characters,
    *  and to clear the line if the user wishes; echo what use types
    */
   public static final int AMOUNT_MODE = 2;
   
   /** Read input in menu choice mode - wait for one digit key to be pressed,
    *  and return value immediately.
    */
   public static final int MENU_MODE = 3;
}
