import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.gordon.common.StatusEventBus;

public class SystemStatusTest
{
	private StatusEventBus status;
	private String status1;

	@Before
	public void beforeTest() {
		this.status = StatusEventBus.getInstance();
		this.status1 = "test";
	}

	@Test
	public void setTest() {
		status.set(status1, true);

		assertTrue(status.is(status1));
	}

	@Test
	public void persistenceTest() {
		assertTrue(status.is(status1));
	}
}
