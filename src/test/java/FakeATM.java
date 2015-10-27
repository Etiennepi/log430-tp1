import com.google.common.eventbus.Subscribe;

import edu.gordon.common.StatusEventBus;
import edu.gordon.common.events.CardInsertedEvent;
import edu.gordon.common.events.TurnOffEvent;
import edu.gordon.common.events.TurnOnEvent;


public class FakeATM implements Runnable
{
	private boolean turnedOn = false;
	private boolean turnedOff = false;
	private boolean cardInserted = false;

	public FakeATM()
	{
		StatusEventBus.getInstance().registerToEventBus(this);
	}

	@Subscribe
	public void handleTurnOnEvent(TurnOnEvent e) {
		turnedOn = true;
	}

	@Subscribe
	public void handleTurnOffEvent(TurnOffEvent e) {
		turnedOff = true;
	}

	@Subscribe
	public void handleCardInsertedEvent(CardInsertedEvent e) {
		cardInserted = true;
	}

	public boolean isTurnedOn() {
		return turnedOn;
	}

	public boolean isTurnedOff() {
		return turnedOff;
	}

	public boolean isCardInserted() {
		return cardInserted;
	}

	public void run()
	{
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
