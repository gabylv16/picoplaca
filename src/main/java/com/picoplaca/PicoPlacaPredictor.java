package main.java.com.picoplaca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PicoPlacaPredictor {

	/**
	 * Main method: determines if a vehicle can circulate at a given date and hour
	 * 
	 * @param licPlate
	 * @param date     format dd/MM/yyyy
	 * @param hour     format HH:mm (0-24 hours)
	 * @return true if vehicle can be on the road and false if can't
	 */
	public boolean predictPicoPlaca(String licPlate, String date, String hour) {
		int lastDigit = Character.getNumericValue(licPlate.charAt(licPlate.length() - 1));
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate givenDate = LocalDate.parse(date, dateFormatter);
		DayOfWeek PicoPlacaDay = getPicoPlacaDay(lastDigit);
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime givenTime = LocalTime.parse(hour, timeFormatter);

		if (givenDate.getDayOfWeek().equals(PicoPlacaDay)) {
			return canCirculate(givenTime);
		} else {
			return true;
		}

	}

	/**
	 * determines the day of "Pico y Placa" based on the last digit of the license
	 * plate
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
