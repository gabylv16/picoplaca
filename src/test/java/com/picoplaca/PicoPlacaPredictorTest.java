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
		String licPlate = new String("ABC101");
		String date = new String("26/08/2019"); // monday
		String hour = new String("19:00"); // boundary hour

		boolean expected = false;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase1() {
		String licPlate = new String("ABC123");
		String date = new String("27/08/2019"); // tuesday
		String hour = new String("19:31");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase2() {
		String licPlate = new String("ABC102");
		String date = new String("28/08/2019"); // wednesday
		String hour = new String("19:00");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase3() {
		String licPlate = new String("ABC128");
		String date = new String("29/08/2019"); // thursday
		String hour = new String("12:00");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase4() {
		String licPlate = new String("ABC100");
		String date = new String("30/08/2019"); // friday
		String hour = new String("08:00");

		boolean expected = false;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase5() {
		String licPlate = new String("ABC123");
		String date = new String("31/08/2019"); // saturday
		String hour = new String("19:00");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase6() {
		String licPlate = new String("ABC123");
		String date = new String("01/09/2019"); // sunday
		String hour = new String("19:00");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase7() {
		String licPlate = new String("ABC1237");
		String date = new String("29/08/2019"); // thursday
		String hour = new String("06:59");

		boolean expected = true;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testCase8() {
		String licPlate = new String("ABC122");
		String date = new String("02/09/2019"); // monday
		String hour = new String("19:29");

		boolean expected = false;
		boolean actual = solution.predictPicoPlaca(licPlate, date, hour);

		Assert.assertEquals(expected, actual);
	}
}
