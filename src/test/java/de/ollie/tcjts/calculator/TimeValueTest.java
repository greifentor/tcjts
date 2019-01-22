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

	private static final long UNITS = 4711;

	@Test
	public void construtor_PassMillis_SetsTheMillisCorrectly() {
		// Prepare
		long expected = UNITS;
		// Run
		TimeValue testee = new TimeValue(UNITS);
		// Check
		long returned = testee.getUnits();
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
		boolean returned = new TimeValue(UNITS).equals(null);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassValueOfDifferentClass_ReturnsFalse() {
		// Prepare
		boolean expected = false;
		// Run
		boolean returned = new TimeValue(UNITS).equals(";op");
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassDifferentObject_ReturnsFalse() {
		// Prepare
		boolean expected = false;
		// Run
		boolean returned = new TimeValue(UNITS).equals(new TimeValue(UNITS - 1));
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassEqualObject_ReturnsTrue() {
		// Prepare
		boolean expected = true;
		// Run
		boolean returned = new TimeValue(UNITS).equals(new TimeValue(UNITS));
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void equals_PassSameObject_ReturnsTrue() {
		// Prepare
		boolean expected = true;
		TimeValue value = new TimeValue(UNITS);
		// Run
		boolean returned = value.equals(value);
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void hashCode_EqualValuesForEqualObjects() {
		// Prepare
		int expected = new TimeValue(UNITS).hashCode();
		// Run
		int returned = new TimeValue(UNITS).hashCode();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void hashCode_EqualValuesForSameObject() {
		// Prepare
		TimeValue value = new TimeValue(UNITS);
		int expected = value.hashCode();
		// Run
		int returned = value.hashCode();
		// Check
		assertThat(returned, equalTo(expected));
	}

	@Test
	public void toString_ReturnsACorrectStringRepresentation() {
		// Prepare
		String expected = "TimeValue[units=" + UNITS + "]";
		// Run
		String returned = new TimeValue(UNITS).toString();
		// Check
		assertThat(returned, equalTo(expected));
	}

}