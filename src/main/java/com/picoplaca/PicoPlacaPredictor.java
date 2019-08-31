package main.java.com.picoplaca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PicoPlacaPredictor {

	public boolean predictPicoPlaca(String licPlate, String date, String hour) {
		// TODO
		return false;
	}

	/**
	 * 
	 * @param lastDigit of the license plate
	 * @return the day of the week of "Pico y Placa" for the given digit
	 */
	private DayOfWeek getPicoPlacaDay(int lastDigit) {

		if (lastDigit == 1 || lastDigit == 2) {
			return DayOfWeek.MONDAY;
		}
		if (lastDigit == 3 || lastDigit == 4) {
			return DayOfWeek.TUESDAY;
		}
		if (lastDigit == 5 || lastDigit == 6) {
			return DayOfWeek.WEDNESDAY;
		}
		if (lastDigit == 7 || lastDigit == 8) {
			return DayOfWeek.THURSDAY;
		}
		if (lastDigit == 9 || lastDigit == 0) {
			return DayOfWeek.FRIDAY;
		}

		return null;
	}

	/**
	 * determines if a vehicle can circulate at a given hour
	 * 
	 * @param givenTime
	 * @return true if can circulate, false if cannot
	 */
	private boolean canCirculate(LocalTime givenTime) {

		if (PicoPlacaConstants.FIRST_FRAME_INITIAL_TIME.isAfter(givenTime)
				|| PicoPlacaConstants.FIRST_FRAME_FINAL_TIME.isBefore(givenTime)
						&& PicoPlacaConstants.SECOND_FRAME_INITIAL_TIME.isAfter(givenTime)
				|| PicoPlacaConstants.SECOND_FRAME_FINAL_TIME.isBefore(givenTime)) {
			return true;
		}
		return false;

	}
}
