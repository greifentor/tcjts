package de.ollie.tcjts.calculator.impl;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import de.ollie.tcjts.calculator.TimeUnit;
import de.ollie.tcjts.calculator.TimeValue;
import de.ollie.tcjts.calculator.TimeValueParserException;

/**
 * Unit tests of class "TimesValueParserImpl".
 *
 * @author ollie
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TimeValueParserImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@InjectMocks
	private TimeValueParserImpl unitUnderTest;

	@Test(expected = IllegalArgumentException.class)
	public void parse_PassANulLValue_ThrowsAnException() {
		this.unitUnderTest.parse(null);
	}

	@Test
	public void parse_PassAStringWithInvalidCharacters_ThrowsAnException() {
		// Prepare
		String invalid = ";op";
		this.thrown.expect(TimeValueParserException.class);
		this.thrown.expectMessage(equalTo("character '" + invalid.charAt(0) + "' is not valid in '" + invalid + "'."));
		// Run
		this.unitUnderTest.parse(invalid);
	}

	@Test
	public void parse_PassAStringWithoutATimeUnit_ThrowsAnException() {
		// Prepare
		String invalid = "4711";
		this.thrown.expect(TimeValueParserException.class);
		this.thrown.expectMessage(equalTo("string '" + invalid + "' does not contain any time unit."));
		// Run
		this.unitUnderTest.parse(invalid);
	}

	@Test
	public void parse_PassAnEmptyString_ReturnsATimeValueFor0Units() {
		// Prepare
		TimeValue expected = new TimeValue(0);
		String passed = "";
		// Run
		TimeValue returned = this.unitUnderTest.parse(passed);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void parse_PassAStringFor5Minutes_ReturnsATimeValueFor5Minutes() {
		// Prepare
		TimeValue expected = new TimeValue(TimeUnit.MINUTE.getUnits() * 5);
		String passed = "5m";
		// Run
		TimeValue returned = this.unitUnderTest.parse(passed);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void parse_PassAStringFor1ForAllUnits_ReturnsATimeValueFor1ForAllUnits() {
		// Prepare
		TimeValue expected = new TimeValue(TimeUnit.MINUTE.getUnits() + TimeUnit.HOUR.getUnits()
				+ TimeUnit.DAY.getUnits() + TimeUnit.WEEK.getUnits());
		String passed = "1w 1d 1h 1m";
		// Run
		TimeValue returned = this.unitUnderTest.parse(passed);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void parse_PassAStringFor1ForAllUnitsNoSpaces_ReturnsATimeValueFor1ForAllUnits() {
		// Prepare
		TimeValue expected = new TimeValue(TimeUnit.MINUTE.getUnits() + TimeUnit.HOUR.getUnits()
				+ TimeUnit.DAY.getUnits() + TimeUnit.WEEK.getUnits());
		String passed = "1w1d1h1m";
		// Run
		TimeValue returned = this.unitUnderTest.parse(passed);
		// Check
		assertThat(returned, equalTo(expected));
	}

}