import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import edu.gordon.atm.ATM;
import edu.gordon.atm.Inquiry;
import edu.gordon.bank_simulation.Receipt;
import edu.gordon.common.Card;
import edu.gordon.common.exceptions.Cancelled;

public class InquiryTest
{
	private FakeContext theSimulation;
	private ATM theATM;
	
	@Before
	public void beforeTest() {
        theSimulation = new FakeContext();
        theSimulation.setMode(FakeContext.INQUIRY_MODE);
        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                             null /* We're not really talking to a bank! */, theSimulation);
        
        new Thread(theATM).start();
	}
	
	@Test
	public void test() {
		Inquiry inquiry = new Inquiry(theATM, null, new Card(2), 1234);
		try {
			inquiry.getSpecificsFromCustomer();
			Receipt receipt = inquiry.completeTransaction();
			Assert.assertTrue(receipt.getDetails().length > 0);
		} catch (Cancelled e) {
			Assert.fail();
		}
	}
}
