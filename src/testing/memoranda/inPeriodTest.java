package testing.memoranda;

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
		assertTrue(test.inPeriod(testYesterday,testTomorrow));
		
	}

}
