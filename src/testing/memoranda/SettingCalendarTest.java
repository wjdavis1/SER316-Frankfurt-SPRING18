package testing.memoranda;

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
		
		assertEquals(actualDate.getTimeInMillis(), testCalendar.getDate().getTime());
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
		

		
		assertEquals(testCalendar2.getDate().getTime(), myDate.getTimeInMillis());
	}
	
	@Test
	/*
	 * Test Evaluates the Today Method
	 */
	public void TodayTest() {
		CalendarDate testToday = CalendarDate.today();

		Calendar today = Calendar.getInstance();
		
		assertEquals(testToday.getDate().getTime(), today.getTimeInMillis());
		
	}
	
	@Test
	/*
	 * Test Yesterday Method
	 */
	
	public void YesterdayTest() {
		CalendarDate testYesterday = CalendarDate.yesterday();
		
		Calendar yesterday = Calendar.getInstance();
		
		yesterday.roll(Calendar.DATE, false);
		
		assertEquals(testYesterday.getDate().getTime(), yesterday.getTimeInMillis());
	}
	
	@Test
	/*
	 * Test Tomorrow Method
	 */
	public void TomorrowTest() {
		CalendarDate testTomorrow = CalendarDate.tomorrow();
		
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.roll(Calendar.DATE, true);
		
		assertEquals(testTomorrow.getDate().getTime(), tomorrow.getTimeInMillis());
	}

}
