package de.ollie.tcjts.calculator;

/**
 * Identifiers for time units.
 *
 * @author ollie
 *
 */
public enum TimeUnit {

	MINUTE("m", 60, null), //
	HOUR("h", 60, MINUTE), //
	DAY("d", 8, HOUR), //
	WEEK("w", 5, DAY);
	private String identifier = null;
	private long timesPredecessor = 0;
	private TimeUnit predecessor = null;

	private TimeUnit(String identifier, long timesPrecessor, TimeUnit predecessor) {
		this.identifier = identifier;
		this.timesPredecessor = timesPrecessor;
		this.predecessor = predecessor;
	}

	/**
	 * Returns the count of units for the time unit.
	 * 
	 * @return The count of units for the time unit.
	 */
	public long getUnits() {
		long result = this.timesPredecessor;
		TimeUnit tu = this;
		while (tu.predecessor != null) {
			tu = tu.predecessor;
			result *= tu.timesPredecessor;
		}
		return result;
	}

	/**
	 * Returns the time unit for the passed identifier (or "null" if no time unit is existing for the passed
	 * identifier).
	 * 
	 * @param identifier The identifier whose time unit is to return.
	 * @return The time unit which is related to the passed identifier or "null" if no time unit is found for the passed
	 *         identifier.
	 */
	public static TimeUnit getTimeUnit(String identifier) {
		for (TimeUnit tu : values()) {
			if (tu.identifier.equalsIgnoreCase(identifier)) {
				return tu;
			}
		}
		return null;
	}

}