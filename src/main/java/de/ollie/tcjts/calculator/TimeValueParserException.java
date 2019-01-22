package de.ollie.tcjts.calculator;

/**
 * An exception which is thrown if an error is detected while parsing a string with a JIRA style timestamp.
 *
 * @author ollie
 *
 */
public class TimeValueParserException extends RuntimeException {

	/**
	 * Creates a new time value parser exception with the passed message.
	 *
	 * @param message A message for the exception.
	 */
	public TimeValueParserException(String message) {
		super(message);
	}

}