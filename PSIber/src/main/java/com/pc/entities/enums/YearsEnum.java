package com.pc.entities.enums;

import java.util.Calendar;

public enum YearsEnum {

	year2018() {
		@Override
		public int getYear() {
			//Getting the current
			//int year = Calendar.getInstance().get(Calendar.YEAR);
			int year=2018;
			return year;
		}
	},

	year2017() {
		@Override
		public int getYear() {
			
			//Getting the previous year
			/*Calendar prevYear = Calendar.getInstance();
		     prevYear.add(Calendar.YEAR, -1);
		     prevYear.get(Calendar.YEAR)*/
		    int year=2017;
			return year;
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
