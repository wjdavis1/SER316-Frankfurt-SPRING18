package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.memoranda.date.*;
import java.util.Calendar;
import main.java.memoranda.util.Util;

class SettingCalendarTest {
	
	CalendarDate testCalendar = new CalendarDate();
	
	@Test
	/*
	 * Test Evaluates the Time since epoch to ensure that the calendar class is 
	 * grabbing the correct date.
	 */
	public void SettingTodaysDateTest() {
		
		Calendar actualDate = Calendar.getInstance();
		long actualDateTestSec = actualDate.getTimeInMillis();
		long testCalendarTestSec = testCalendar.getDate().getTime();
		
		assertEquals(testCalendarTestSec, actualDateTestSec);
	}
	
	@Test
	/*
	 * Test Evaluates the creation of a custom date in the calendar, then
	 * evaluates based on the millisecond conversion.
	 */
	public void CreateCustomCalendarDateTest() {
		
	
		CalendarDate testCalendar2 = new CalendarDate(26,Calendar.AUGUST,2018);
		Calendar myDate = Calendar.getInstance();
		
		myDate.set(2018, Calendar.AUGUST, 26);
		
		long testCalendarDate = testCalendar2.getDate().getTime();
		long testMyDate = myDate.getTimeInMillis();
		
		assertEquals(testCalendarDate, testMyDate);
	}
	
	@Test
	/*
	 * Test Evaluates the Today Method
	 */
	public void TodayTest() {
		CalendarDate testToday = CalendarDate.today();

		Calendar today = Calendar.getInstance();
		
		long testTodaySec = testToday.getDate().getTime();
		long todaySec = today.getTimeInMillis();
		
		assertEquals(testTodaySec, todaySec);
		
	}
	
	@Test
	/*
	 * Test Yesterday Method
	 */
	
	public void YesterdayTest() {
		CalendarDate testYesterday = CalendarDate.yesterday();
		
		Calendar yesterday = Calendar.getInstance();
		
		yesterday.roll(Calendar.DATE, false);
		
		long yesterdaySec = yesterday.getTimeInMillis();
		long testYesterdaySec = testYesterday.getDate().getTime();
		
		assertEquals(testYesterdaySec, yesterdaySec);
	}
	
	@Test
	/*
	 * Test Tomorrow Method
	 */
	public void TomorrowTest() {
		CalendarDate testTomorrow = CalendarDate.tomorrow();
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.roll(Calendar.DATE, true);
		
		long testTomorrowSec = testTomorrow.getDate().getTime();
		long tomorrowSec = tomorrow.getTimeInMillis();
		
		assertEquals(testTomorrowSec, tomorrowSec);
	}

}
