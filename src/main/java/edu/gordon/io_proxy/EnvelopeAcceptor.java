/* * ATM Example system - file EnvelopeAcceptor.java * * copyright (c) 2001 - Russell C. Bjork * */package edu.gordon.io_proxy;import edu.gordon.common.exceptions.Cancelled;/** Manager for the ATM's envelope acceptor.  In a real ATM, this would *  manage a physical device; in this edu.gordon.simulation,  it uses classes *  in package edu.gordon.simulation to simulate the device. */public class EnvelopeAcceptor{    /** Constructor     *     *  @param log the log in which to record receiving an envelope     */    public EnvelopeAcceptor(Log log, Context context)    {        this.log = log;        this.context = context;    }    /** Accept an envelope from customer.     *     *  @exception Cancelled if operation timed out or the     *             customer cancelled it     */    public void acceptEnvelope() throws Cancelled    {        boolean inserted = context.acceptEnvelope();        if (inserted)            log.logEnvelopeAccepted();        else            throw new Cancelled();    }    /** Log in which to record receiving an envelope     */    private Log log;    /** The current context.     */    private Context context;}