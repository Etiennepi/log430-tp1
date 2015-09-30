/* * ATM Example system - file Withdrawal.java * * copyright (c) 2001 - Russell C. Bjork * */package edu.gordon.atm;import edu.gordon.bank_proxy.Message;import edu.gordon.bank_simulation.AccountInformation;import edu.gordon.bank_simulation.Receipt;import edu.gordon.common.Card;import edu.gordon.common.Money;import edu.gordon.common.exceptions.Cancelled;import edu.gordon.io_proxy.CustomerConsole;/** Representation for a cash withdrawal transaction */public class Withdrawal extends Transaction{    /** Constructor     *     *  @param atm the ATM used to communicate with customer     *  @param session the session in which the transaction is being performed     *  @param card the customer's card     *  @param pin the PIN entered by the customer     */    public Withdrawal(ATM atm, Session session, Card card, int pin)    {        super(atm, session, card, pin);    }    /** Get specifics for the transaction from the customer     *     *  @return message to bank for initiating this transaction     *  @exception CustomerConsole.Cancelled if customer cancelled this transaction     */    public Message getSpecificsFromCustomer() throws Cancelled    {        from = atm.getCustomerConsole().readMenuChoice(            "Account to withdraw from",            AccountInformation.ACCOUNT_NAMES);        String [] amountOptions = { "$20", "$40", "$60", "$100", "$200" };        Money [] amountValues = {                                  new Money(20), new Money(40), new Money(60),                                  new Money(100), new Money(200)                                };        String amountMessage = "";        boolean validAmount = false;        while (! validAmount)        {            amount = amountValues [                atm.getCustomerConsole().readMenuChoice(                    amountMessage + "Amount of cash to withdraw", amountOptions) ];            validAmount = atm.getCashDispenser().checkCashOnHand(amount);            if (! validAmount)                amountMessage = "Insufficient cash available\n";        }        return new Message(Message.WITHDRAWAL,                           card, pin, serialNumber, from, -1, amount);    }    /** Complete an approved transaction     *     *  @return receipt to be printed for this transaction     */    public Receipt completeTransaction()    {        String[] detailsPortion = new String[2];        atm.getCashDispenser().dispenseCash(amount);        detailsPortion[0] = "WITHDRAWAL FROM: " + AccountInformation.ACCOUNT_ABBREVIATIONS[from];        detailsPortion[1] = "AMOUNT: " + amount.toString();        return new Receipt(this.atm, this.card, this.serialNumber, this.balances, detailsPortion);    }    /** Account to withdraw from     */    private int from;    /** Amount of money to withdraw     */    private Money amount;}