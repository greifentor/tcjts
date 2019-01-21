package de.ollie.tcjts.calculator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Unit tests for class "TimeValue".
 *
 * @author ollie
 *
 */
public class TimeValueTest {

	private static final long MILLIS = 4711;

	@Test
	public void construtor_PassMillis_SetsTheMillisCorrectly() {
		// Prepare
		long expected = MILLIS;
		// Run
		TimeValue testee = new TimeValue(MILLIS);
		// Check
		long returned = testee.getMillis();
		assertThat(returned, equalTo(expected));
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructor_PassNegativeValue_ThrowsAnException() {
		new TimeValue(-1);
	}

	@Test
	public void equals_PassNullValue_ReturnsFalse() {
		// Prepare
		boolean expected = false;
		// Run
		boolean returned = new TimeValue(MILLIS).equals(null);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassValueOfDifferentClass_ReturnsFalse() {
		// Prepare
		boolean expected = false;
		// Run
		boolean returned = new TimeValue(MILLIS).equals(";op");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassDifferentObject_ReturnsFalse() {
		// Prepare
		boolean expected = false;
		// Run
		boolean returned = new TimeValue(MILLIS).equals(new TimeValue(MILLIS - 1));
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassEqualObject_ReturnsTrue() {
		// Prepare
		boolean expected = true;
		// Run
		boolean returned = new TimeValue(MILLIS).equals(new TimeValue(MILLIS));
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassSameObject_ReturnsTrue() {
		// Prepare
		boolean expected = true;
		TimeValue value = new TimeValue(MILLIS);
		// Run
		boolean returned = value.equals(value);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void hashCode_EqualValuesForEqualObjects() {
		// Prepare
		int expected = new TimeValue(MILLIS).hashCode();
		// Run
		int returned = new TimeValue(MILLIS).hashCode();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void hashCode_EqualValuesForSameObject() {
		// Prepare
		TimeValue value = new TimeValue(MILLIS);
		int expected = value.hashCode();
		// Run
		int returned = value.hashCode();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void toString_ReturnsACorrectStringRepresentation() {
		// Prepare
		String expected = "TimeValue[millis=" + MILLIS + "]";
		// Run
		String returned = new TimeValue(MILLIS).toString();
		// Check
		assertThat(returned, equalTo(expected));
	}

}