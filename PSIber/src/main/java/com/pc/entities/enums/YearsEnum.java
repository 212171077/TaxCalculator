package com.pc.entities.enums;

import java.util.Calendar;

/**
 * This Enum Auto calculate and
 * return current and previous year
 */
public enum YearsEnum {

	currentYear() {
		@Override
		public int getYear() {
			//Getting the current
			int year = Calendar.getInstance().get(Calendar.YEAR);
			return year;
		}
	},

	lastYear() {
		@Override
		public int getYear() {
			
			//Getting the previous year
			Calendar prevYear = Calendar.getInstance();
		    prevYear.add(Calendar.YEAR, -1);
			return prevYear.get(Calendar.YEAR);
		}
	};
	
	/** The year*/
	private int year;

	/**
	 * InstantiatesYearsEnum
	 */
	private YearsEnum() {
	}
	
	/**
	 * Gets year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

}
