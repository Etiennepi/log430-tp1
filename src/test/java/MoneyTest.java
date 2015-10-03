import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.gordon.common.Money;

public class MoneyTest
{
	private Money money1;
	private Money money2;

	@Before
	public void setUp() throws Exception
	{
		money1 = new Money(2, 50);
		money2 = new Money(7, 50);
	}

	@Test
	public void lesserThanTest() {
		assertTrue(money1.lessEqual(money2));
	}

	@Test
	public void substractTest() {
		Money money3 = new Money(5, 0);
		money2.subtract(money1);
		assertTrue(money3.equal(money2));
	}

	@Test
	public void addTest() {
		Money money3 = new Money(10, 0);
		money1.add(money2);
		assertTrue(money3.equal(money1));
	}

	@Test
	public void copyTest() {
		Money money3 = new Money(money1);
		assertTrue(money3.equal(money1));
	}
}
