package trng.util;

import java.util.Calendar;

public class AgeCalculator {
	public static void main(String args[]) {
		calculateMyAge();
	}

	private static void calculateMyAge() {
		// Scanner scanner = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		// System.out.println(" Enter you birth year : " );
		// calendar.set(calendar.YEAR, scanner.nextInt());
		//
		// System.out.println(" Enter you birth month : " );
		// calendar.set(calendar.MONTH, scanner.nextInt());
		//
		// System.out.println(" Enter you birth day : " );
		// calendar.set(calendar.DAY_OF_MONTH, scanner.nextInt());

//		int birthYear = 1979;
//		int birthMonth = 06 - 1;
//		int birthDay = 10;

		int birthYear = 1979;
		int birthMonth = 01 - 1;
		int birthDay = 29;
		
		int days = 0;
		boolean lessAMonth = false;
		int years = 0;

		if (Calendar.getInstance().get(calendar.DAY_OF_MONTH) < birthDay) {
			days = (getNumberOfDaysInMonth(birthYear, getPriorMonth(birthMonth))
					+ Calendar.getInstance().get(calendar.DAY_OF_MONTH)) - birthDay;
			lessAMonth = true;
		} else {
			days = Calendar.getInstance().get(calendar.DAY_OF_MONTH) - birthDay;
		}

		int months = 0;
		boolean lessAYear = false;
		if (lessAMonth && getPriorMonth(birthMonth) < birthMonth) {
			months = (12 + Calendar.getInstance().get(calendar.MONTH) - 1) - birthMonth;
			lessAYear = true;
		} else if (lessAMonth && getPriorMonth(birthMonth) >= birthMonth) {
			months = (Calendar.getInstance().get(calendar.MONTH) - 1) - birthMonth;
		} else if (!lessAMonth && Calendar.getInstance().get(calendar.MONTH) < birthMonth) {
			months = (12 + (Calendar.getInstance().get(calendar.MONTH) + 1) - 1) - birthMonth;
			lessAYear = true;
		} else if (!lessAMonth && Calendar.getInstance().get(calendar.MONTH) >= birthMonth) {
			months = Calendar.getInstance().get(calendar.MONTH) - birthMonth;
		}

		if (lessAYear) {
			years = Calendar.getInstance().get(calendar.YEAR) - 1 - birthYear;
		} else {
			years = Calendar.getInstance().get(calendar.YEAR) - birthYear;
		}

		System.out.println("Your age is: " + years + " years, " + months + " months " + days + " days ");
	}

	private static int getPriorMonth(int birthMonth) {
		if ((birthMonth - 01) > 01) {
			return birthMonth - 01;
		} else {
			return Calendar.DECEMBER;
		}

	}

	private static int getNumberOfDaysInMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}