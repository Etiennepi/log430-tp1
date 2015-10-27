import edu.gordon.bank_proxy.Message;
import edu.gordon.bank_simulation.Balances;
import edu.gordon.bank_simulation.SimulatedBank;
import edu.gordon.bank_simulation.Status;
import edu.gordon.common.Card;
import edu.gordon.common.Money;
import edu.gordon.common.StatusEventBus;
import edu.gordon.io_proxy.Context;

public class FakeContext extends Context {
	private String mode;
	private SimulatedBank simulatedBank;
	private int withdrawCount = 1;
	
	public static final String INQUIRY_MODE = "1";
	public static final String DEPOSIT_MODE = "2";
	public static final String WITHDRAW_MODE = "3";
	public static final String TRANSFER_MODE = "4";
	
	public FakeContext() {
		simulatedBank = new SimulatedBank();
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	@Override
	public Money getInitialCash() {
		return new Money(100);
	}

	@Override
	public Card readCard() {
		StatusEventBus.getInstance().set("cardInserted", true);
		return new Card(2);
	}

	@Override
	public void ejectCard() {
		StatusEventBus.getInstance().set("cardInserted", false);

	}

	@Override
	public void retainCard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void display(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public String readInput(int mode, int maxValue) {
		String input = "";
		switch (Integer.parseInt(this.mode)) {
		case 1:
	        if (mode == AMOUNT_MODE)
	            input = "20";
	        else
	            input = "2";
			
			break;

		case 2:
	        if (mode == AMOUNT_MODE)
	        	input = "20";
	        else
	        	input = "2";
	        
			break;
		case 3:
	        if (mode == AMOUNT_MODE)
	        	input = "20";
	        else
	        	if (this.withdrawCount == 2) {
	        		this.withdrawCount = 1;
	        	}
	        	input = Integer.toString(this.withdrawCount);
	        	this.withdrawCount ++;
	        
			break;
		case 4:
	        if (mode == AMOUNT_MODE)
	        	input = "20";
	        else
	        	input = "2";
	        
			break;
		}
		
		return input;
	}

	@Override
	public void dispenseCash(Money amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean acceptEnvelope() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void printReceiptLine(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printLogLine(String text) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status sendMessage(Message message, Balances balances) {
        return simulatedBank.handleMessage(message, balances);
	}

	@Override
	public void switchChanged(boolean on) {
		// The card reader is only enabled when the switch is on

    	StatusEventBus status = StatusEventBus.getInstance();

        if (on)
        	status.set("active", true);
        else
        	status.set("active", false);
	}

    /** Notify ATM that a card has been inserted
     */
    public void cardInserted()
    {
    	StatusEventBus status = StatusEventBus.getInstance();
    	status.set("cardInserted", true);
    }

}
