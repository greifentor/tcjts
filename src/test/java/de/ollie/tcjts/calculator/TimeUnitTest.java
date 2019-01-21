package de.ollie.tcjts.calculator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

/**
 * Unit tests for class "TimeUnit".
 *
 * @author ollie
 *
 */
public class TimeUnitTest {

	@Test
	public void getMillisPerUnit_Returns60000ForMINUTE() {
		// Prepare
		long expected = 60000;
		// Run
		long returned = TimeUnit.MINUTE.getMillisPerUnit();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getMillisPerUnit_Returns60000Times60ForHOUR() {
		// Prepare
		long expected = 60000 * 60;
		// Run
		long returned = TimeUnit.HOUR.getMillisPerUnit();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getMillisPerUnit_Returns60000Times60Times8ForDAY() {
		// Prepare
		long expected = 60000 * 60 * 8;
		// Run
		long returned = TimeUnit.DAY.getMillisPerUnit();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getMillisPerUnit_Returns60000Times60Times8Times5ForWEEK() {
		// Prepare
		long expected = 60000 * 60 * 8 * 5;
		// Run
		long returned = TimeUnit.WEEK.getMillisPerUnit();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassANullValue_ReturnsANullValue() {
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit(null);
		// Check
		assertThat(returned, nullValue());
	}

	@Test
	public void getTimeUnit_PassAInvalidIdentifier_ReturnsANullValue() {
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit(";op");
		// Check
		assertThat(returned, nullValue());
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForDayLowerCase_ReturnsTheTimeUnitForDAY() {
		// Prepare
		TimeUnit expected = TimeUnit.DAY;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("d");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForDayUpperCase_ReturnsTheTimeUnitForDAY() {
		// Prepare
		TimeUnit expected = TimeUnit.DAY;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("D");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForHourLowerCase_ReturnsTheTimeUnitForHOUR() {
		// Prepare
		TimeUnit expected = TimeUnit.HOUR;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("h");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForHourUpperCase_ReturnsTheTimeUnitForHOUR() {
		// Prepare
		TimeUnit expected = TimeUnit.HOUR;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("H");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForMinuteLowerCase_ReturnsTheTimeUnitForMINUTE() {
		// Prepare
		TimeUnit expected = TimeUnit.MINUTE;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("m");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForMinuteUpperCase_ReturnsTheTimeUnitForMINUTE() {
		// Prepare
		TimeUnit expected = TimeUnit.MINUTE;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("M");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForWeekLowerCase_ReturnsTheTimeUnitForWEEK() {
		// Prepare
		TimeUnit expected = TimeUnit.WEEK;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("w");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void getTimeUnit_PassAValidIdentifierForWeekUpperCase_ReturnsTheTimeUnitForWEEK() {
		// Prepare
		TimeUnit expected = TimeUnit.WEEK;
		// Run
		TimeUnit returned = TimeUnit.getTimeUnit("W");
		// Check
		assertThat(returned, equalTo(expected));
	}

}