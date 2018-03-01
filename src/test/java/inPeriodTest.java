package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.memoranda.date.*;
import java.util.Calendar;
import main.java.memoranda.util.Util;

class inPeriodTest {

	CalendarDate test = new CalendarDate();
	
	@Test
	public void inPeriodTest() {
		
		CalendarDate testYesterday = CalendarDate.yesterday();
		CalendarDate testTomorrow = CalendarDate.tomorrow();
		
		assertFalse(test.inPeriod(testTomorrow,testYesterday));
		assertFalse(test.inPeriod(testYesterday,testTomorrow));
		
	}

}
