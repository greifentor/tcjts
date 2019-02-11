package de.ollie.tcjts.calculator;

import static de.ollie.utils.Check.ensure;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A container for time values.
 *
 * @author ollie
 *
 */
final public class TimeValue {

	private long units = 0;

	/**
	 * Creates a new times value object with the passed milliseconds.
	 *
	 * @param units The units for the time value.
	 * @throws IllegalArgumentException Passing a value less than 0.
	 */
	public TimeValue(long units) {
		super();
		ensure(units > -1, "units cannot be less than zero.");
		this.units = units;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Returns the units value of the object.
	 *
	 * @return The units value of the object.
	 */
	public long getUnits() {
		return this.units;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}