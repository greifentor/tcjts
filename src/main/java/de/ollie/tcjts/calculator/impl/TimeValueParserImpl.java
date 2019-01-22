package de.ollie.tcjts.calculator.impl;

import static de.ollie.tcjts.util.Check.ensure;

import org.springframework.stereotype.Component;

import de.ollie.tcjts.calculator.TimeUnit;
import de.ollie.tcjts.calculator.TimeValue;
import de.ollie.tcjts.calculator.TimeValueParser;
import de.ollie.tcjts.calculator.TimeValueParserException;

/**
 * An implementation of the TimeValueParser interface.
 * 
 * @author ollie
 *
 */
@Component
public class TimeValueParserImpl implements TimeValueParser {

	@Override
	public TimeValue parse(String s) {
		ensure(s != null, "string to parse cannot be null");
		s = s.replace(" ", "").trim();
		long units = 0;
		if (!s.isEmpty()) {
			boolean timeUnitFound = false;
			long value = 0;
			for (int i = 0, leni = s.length(); i < leni; i++) {
				char c = s.charAt(i);
				String identifier = String.valueOf(c);
				if (Character.isDigit(c)) {
					value = value * 10 + (c - '0');
				} else {
					TimeUnit tu = TimeUnit.getTimeUnit(identifier);
					if (tu != null) {
						units += value * tu.getUnits();
						value = 0;
						timeUnitFound = true;
					} else {
						throw new TimeValueParserException("character '" + c + "' is not valid in '" + s + "'.");
					}
				}
			}
			if (!timeUnitFound) {
				throw new TimeValueParserException("string '" + s + "' does not contain any time unit.");
			}
		}
		return new TimeValue(units);
	}

}