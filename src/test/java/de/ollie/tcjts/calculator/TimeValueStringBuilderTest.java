package de.ollie.tcjts.calculator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Unit tests for class "TimeValueStringBuilder".
 *
 * @author ollie
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeValueStringBuilderTest {

	@InjectMocks
	private TimeValueStringBuilder unitUnderTest;

	@Test
	public void build_PassALargeTimeValue_ReturnsACorrectStringWithMinimumValuesForEachTimeUnit() {
		// Prepare
		String expected = "1w 1d 1h 1m";
		TimeValue timeValue = new TimeValue(TimeUnit.WEEK.getUnits() + TimeUnit.DAY.getUnits()
				+ TimeUnit.HOUR.getUnits() + TimeUnit.MINUTE.getUnits());
		// Run
		String returned = this.unitUnderTest.build(timeValue);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA42MinutesTimeValue_ReturnsACorrectStringWith42Minutes() {
		// Prepare
		String expected = "42m";
		TimeValue timeValue = new TimeValue(TimeUnit.MINUTE.getUnits() * 42);
		// Run
		String returned = this.unitUnderTest.build(timeValue);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA62MinutesTimeValue_ReturnsACorrectStringWith1HourAnd2Minutes() {
		// Prepare
		String expected = "1h 2m";
		TimeValue timeValue = new TimeValue(TimeUnit.MINUTE.getUnits() * 62);
		// Run
		String returned = this.unitUnderTest.build(timeValue);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA495MinutesTimeValue_ReturnsACorrectStringWith1DayAnd15Minutes() {
		// Prepare
		String expected = "1d 15m";
		TimeValue timeValue = new TimeValue(TimeUnit.MINUTE.getUnits() * 495);
		// Run
		String returned = this.unitUnderTest.build(timeValue);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA495MinutesTimeValueSkipEmptyOff_ReturnsACorrectStringWith1Day0HoursAnd15Minutes() {
		// Prepare
		String expected = "1d 0h 15m";
		TimeValue timeValue = new TimeValue(TimeUnit.MINUTE.getUnits() * 495);
		// Run
		String returned = this.unitUnderTest.build(timeValue, false);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA0MinutesTimeValue_ReturnsAnEmptyString() {
		// Prepare
		String expected = "";
		TimeValue timeValue = new TimeValue(0);
		// Run
		String returned = this.unitUnderTest.build(timeValue);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void build_PassA0MinutesTimeValueNoSkipEmptyOff_ReturnsACorrectStringFor0Minutes() {
		// Prepare
		String expected = "0m";
		TimeValue timeValue = new TimeValue(0);
		// Run
		String returned = this.unitUnderTest.build(timeValue, false);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void build_PassANullValue_ThrowsAnException() {
		this.unitUnderTest.build(null);
	}

}