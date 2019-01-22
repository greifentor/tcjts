package de.ollie.tcjts.calculator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

/**
 * Unit tests of class "TimeValueParserException".
 *
 * @author ollie
 *
 */
public class TimeValueParserExceptionTest {

	@Test
	public void constructor_PassAMessage_SetsTheMessageCorrectly() {
		// Prepare
		String expected = "message";
		// Run
		String returned = new TimeValueParserException(expected).getMessage();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void constructor_PassANullValue_SetsNullForTheMessageOfTheException() {
		// Run
		String returned = new TimeValueParserException(null).getMessage();
		// Check
		assertThat(returned, nullValue());
	}

}