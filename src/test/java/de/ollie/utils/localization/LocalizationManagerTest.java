package de.ollie.utils.localization;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import de.ollie.utils.localization.LocalizationManager;
import de.ollie.utils.localization.SupportedLanguage;

/**
 * Unit tests for class "LocalizationManager".
 *
 * @author ollie
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class LocalizationManagerTest {

	private static final String RESOURCE_ID_APPLICATION_TITLE = "application.title";

	@InjectMocks
	private LocalizationManager unitUnderTest;

	@Test
	public void getText_PassingANullValueAsIdentifier_ReturnsANullValue() {
		// Run
		String returned = this.unitUnderTest.getText(null, SupportedLanguage.DE);
		// Check
		assertThat(returned, nullValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getText_PassingANullValue_ReturnsANullValue() {
		this.unitUnderTest.getText(RESOURCE_ID_APPLICATION_TITLE, null);
	}

	@Test
	public void getText_PassingApplicationTitleResourceIdAndLanguageDE_ReturnsTheCorrectLabel() {
		// Run
		String returned = this.unitUnderTest.getText(RESOURCE_ID_APPLICATION_TITLE, SupportedLanguage.DE);
		// Check
		assertThat(returned, equalTo("Kurswahl für die Qualifikationsphase"));
	}

}