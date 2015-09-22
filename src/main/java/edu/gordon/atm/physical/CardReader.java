/* * ATM Example system - file CardReader.java * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm.physical;import edu.gordon.bank_simulation.Card;import edu.gordon.io_simulation.Context;/** Manager for the ATM's card reader.  In a real ATM, this would  *  manage a physical device; in this edu.gordon.simulation, it uses classes  *  in package edu.gordon.simulation to simulate the device.   */ public class CardReader{    /** Constructor     *     *  @param context the current context     */    public CardReader(Context context)    {        this.context = context;    }        // In a real ATM, code would be needed to sense insertion of a card into the    // slot and notify the ATM - simulated in this case by a button in the GUI        /** Read a card that has been partially inserted into the reader     *     *  @return Card object representing information on the card if read     *          successfully, null if not read successfully     */    public Card readCard()    {        return context.readCard();    }        /** Eject the card that is currently inside the reader.       */    public void ejectCard()    {    	context.ejectCard();    }        /** Retain the card that is currently inside the reader for action by the     *  bank.     */    public void retainCard()    {    	context.retainCard();    }        /** The current context.     */    private Context context;}