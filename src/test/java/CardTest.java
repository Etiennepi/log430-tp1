import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.gordon.common.Card;

public class CardTest
{
	@Test
	public void numberTest() {
		int number = 123456;
		Card card = new Card(number);

		assertTrue(number == card.getNumber());
	}
}
