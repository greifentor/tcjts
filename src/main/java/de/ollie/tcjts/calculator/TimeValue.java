package de.ollie.tcjts.calculator;

import static de.ollie.tcjts.util.Check.ensure;

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

	private long millis = 0;

	/**
	 * Creates a new times value object with the passed milliseconds.
	 *
	 * @param millis The milliseconds for the time value.
	 * @throws IllegalArgumentException Passing a value less than 0.
	 */
	public TimeValue(long millis) {
		super();
		ensure(millis > -1, "millis cannot be less than zero.");
		this.millis = millis;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Returns the millisecond value of the object.
	 *
	 * @return The millisecond value of the object.
	 */
	public long getMillis() {
		return this.millis;
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