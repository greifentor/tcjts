package de.ollie.tcjts.calculator;

/**
 * An interface for a parser which is able to process JIRA style timestamps into TimeValue objects.
 *
 * @author ollie
 *
 */
public interface TimeValueParser {

	/**
	 * Parses the passed String and returns a TimeValue object with the value of the string content.
	 *
	 * @param s The string to parse.
	 * @return A TimeValue object with the value of the parsed string or a value zero TimeValue object for an empty
	 *         string.
	 * @throws IllegalArgumentException Passing a null value.
	 * @throws TimeValueParserException If the passed string contains invalid characters.
	 */
	TimeValue parse(String s);

}