/* * ATM Example system - file Inquiry.java    * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm.transaction;import edu.gordon.atm.ATM;import edu.gordon.atm.Session;import edu.gordon.bank_proxy.Message;import edu.gordon.bank_simulation.AccountInformation;import edu.gordon.bank_simulation.Receipt;import edu.gordon.common.Card;import edu.gordon.common.Money;import edu.gordon.io_proxy.CustomerConsole;/** Representation for a balance inquiry transaction */public class Inquiry extends Transaction{    /** Constructor     *     *  @param edu.gordon.atm the ATM used to communicate with customer     *  @param session the session in which the transaction is being performed     *  @param card the customer's card     *  @param pin the PIN entered by the customer     */    public Inquiry(ATM atm, Session session, Card card, int pin)    {        super(atm, session, card, pin);    }        /** Get specifics for the transaction from the customer     *     *  @return message to bank for initiating this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction     */    protected Message getSpecificsFromCustomer() throws CustomerConsole.Cancelled    {        from = atm.getCustomerConsole().readMenuChoice(            "Account to inquire from",            AccountInformation.ACCOUNT_NAMES);        return new Message(Message.INQUIRY,                         card, pin, serialNumber, from, -1, new Money(0));    }        /** Complete an approved transaction     *     *  @return receipt to be printed for this transaction     */    protected Receipt completeTransaction()    {        return new Receipt(this.atm, this.card, this, this.balances) {            {                detailsPortion = new String[2];                detailsPortion[0] = "INQUIRY FROM: " +                                     AccountInformation.ACCOUNT_ABBREVIATIONS[from];                detailsPortion[1] = "";            }        };    }        /** Account to inquire about     */    private int from;    }