package test.java.com.picoplaca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.com.picoplaca.PicoPlacaPredictor;

public class PicoPlacaPredictorTest {
	protected PicoPlacaPredictor solution;

	@Before
	public void setUp() {
		solution = new PicoPlacaPredictor();
	}

	@Test
	public void testCase0() {
		String licPlate = new String("HAK717");
		String date = new String("29/08/2019"); // thursday
		String hour = new String("19:00"); // boundary hour

		boolean expected = false;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

}
