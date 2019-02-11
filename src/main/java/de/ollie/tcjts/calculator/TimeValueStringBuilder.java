package de.ollie.tcjts.calculator;

import static de.ollie.utils.Check.ensure;

/**
 * A class which provides methods to create string representations for a TimeValue object.
 *
 * @author ollie
 *
 */
public class TimeValueStringBuilder {

	/**
	 * Returns a string representation of the passed time value with minimum value for each time unit.
	 *
	 * @param timeValue The time value which the string representation is to create for.
	 * @return A string representation of the passed time value with minimum value for each time unit.
	 * @throws IllegalArgumentException Passing a null value.
	 */
	public String build(TimeValue timeValue) {
		return build(timeValue, true);
	}

	/**
	 * Returns a string representation of the passed time value with minimum value for each time unit.
	 *
	 * @param timeValue The time value which the string representation is to create for.
	 * @param skipEmpty Set this flag to skip the units whose value is "0".
	 * @return A string representation of the passed time value with minimum value for each time unit.
	 * @throws IllegalArgumentException Passing a null value.
	 */
	public String build(TimeValue timeValue, boolean skipEmpty) {
		ensure(timeValue != null, "time value cannot be null.");
		StringBuilder sb = new StringBuilder();
		long remainingUnits = timeValue.getUnits();
		TimeUnit[] timeUnits = TimeUnit.values();
		if (!skipEmpty && (remainingUnits == 0)) {
			return "0" + timeUnits[0].getIdentifier();
		}
		for (int i = timeUnits.length - 1; i >= 0; i--) {
			if (remainingUnits >= timeUnits[i].getUnits()) {
				long count = remainingUnits / timeUnits[i].getUnits();
				remainingUnits = remainingUnits % timeUnits[i].getUnits();
				sb.append(spaceIfNecessary(sb)).append(count).append(timeUnits[i].getIdentifier());
			} else if (!skipEmpty) {
				if (sb.length() > 0) {
					sb.append(spaceIfNecessary(sb)).append("0").append(timeUnits[i].getIdentifier());
				}
			}
		}
		return sb.toString();
	}

	private String spaceIfNecessary(StringBuilder sb) {
		if (sb.length() > 0) {
			return " ";
		}
		return "";
	}

}