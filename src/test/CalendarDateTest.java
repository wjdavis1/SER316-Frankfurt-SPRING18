package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import main.java.memoranda.date.CalendarDate;

/* Tresor Cyubahiro 02.07.2018
 * Add Unit Tests for CalendarDate class 
 */
class CalendarDateTest {
	CalendarDate date = new CalendarDate();
	/*
	 * Test whether the date of instantiation is the same as today's date.
	 */
	@Test
	public void todayDate() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
				
		assertTrue(date.getDay() == day);
		assertTrue(date.getMonth() == month);
		assertTrue(date.getYear() == year);
	}

}
