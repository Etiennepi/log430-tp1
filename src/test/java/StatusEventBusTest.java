import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.gordon.common.StatusEventBus;
import edu.gordon.common.events.CardInsertedEvent;
import edu.gordon.common.events.TurnOffEvent;
import edu.gordon.common.events.TurnOnEvent;


public class StatusEventBusTest
{
	private FakeATM atm;
	private Calendar cal;

	@Before
	public void doBefore() {
		cal = Calendar.getInstance();
	}

	@Test
	public void turnOnTest() {
		atm = new FakeATM();
		new Thread(atm).start();
		StatusEventBus.getInstance().postTurnOnEvent(new TurnOnEvent());
		Date date = cal.getTime();
		while (!atm.isTurnedOn()) {
			if (cal.getTime().getTime() - date.getTime() > 2000) {
				Assert.fail();
			}
		}
		Assert.assertTrue(atm.isTurnedOn());
	}

	@Test
	public void turnOffTest() {
		atm = new FakeATM();
		new Thread(atm).start();
		StatusEventBus.getInstance().postTurnOffEvent(new TurnOffEvent());
		Date date = cal.getTime();
		while (!atm.isTurnedOff()) {
			if (cal.getTime().getTime() - date.getTime() > 2000) {
				Assert.fail();
			}
		}
		Assert.assertTrue(atm.isTurnedOff());
	}

	@Test
	public void insertCardTest() {
		atm = new FakeATM();
		new Thread(atm).start();
		StatusEventBus.getInstance().postCardInsertedEvent(new CardInsertedEvent());
		Date date = cal.getTime();
		while (!atm.isCardInserted()) {
			if (cal.getTime().getTime() - date.getTime() > 2000) {
				Assert.fail();
			}
		}
		Assert.assertTrue(atm.isCardInserted());
	}
}
