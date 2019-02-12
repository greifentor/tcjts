package de.ollie.utils.gui.vaadin;

import org.apache.logging.log4j.util.Strings;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

/**
 * Some utility method for layouts.
 *
 * @author ollie
 *
 */
public class LayoutUtil {

	public static Label createVerticalLine(int height, int width) {
		return createVerticalLine("", height, width);
	}

	public static Label createVerticalLine(String headLine, int height, int width) {
		Label label = new Label("", ContentMode.HTML);
		label.setSizeFull();
		String html = "<hr noshade >";
		label.setValue(html);
		if (!Strings.isBlank(headLine)) {
			label.setCaptionAsHtml(true);
			label.setCaption(headLine);
		}
		return label;
	}

	public static Label createSeparator(int width) {
		Label label = new Label("", ContentMode.PREFORMATTED);
		label.setSizeFull();
		StringBuilder s = new StringBuilder();
		while (width > 0) {
			s.append(" ");
			width--;
		}
		label.setValue(s.toString());
		return label;
	}

	/**
	 * Creates a label for an empty line.
	 * 
	 * @return A label for an empty line.
	 */
	public static Label createEmptyLine() {
		Label label = new Label("<BR>", ContentMode.HTML);
		label.setCaptionAsHtml(true);
		return label;
	}

	/**
	 * Sets the attributes of the passed text field object with caption and id.
	 *
	 * @param textField The text field which is to modify.
	 * @param caption   The caption for the text field.
	 * @param id        The id of the text field.
	 */
	public static void setTextFieldProperties(TextField textField, String caption, String id) {
		textField.setSizeFull();
		textField.setId(id);
		textField.setCaption(caption);
	}

	/**
	 * Sets the properties of a combo box.
	 * 
	 * @param comboBox             The combo box whose properties are to set.
	 * @param caption              A caption for the combo box.
	 * @param id                   An id for the combo box component.
	 * @param listDataProvider     The list provider which acts as data provider for the combo box content.
	 * @param itemCaptionGenerator An item caption generator which creates string representation for the objects managed
	 *                             by the combo box.
	 */
	public static <T> void setComboBoxProperties(ComboBox<T> comboBox, String caption, String id,
			ListDataProvider<T> listDataProvider, ItemCaptionGenerator<T> itemCaptionGenerator) {
		comboBox.setSizeFull();
		comboBox.setId(id);
		comboBox.setCaption(caption);
		comboBox.setItemCaptionGenerator(itemCaptionGenerator);
		comboBox.setDataProvider(listDataProvider);
		if (listDataProvider.getItems().size() == 1) {
			comboBox.setEnabled(false);
			comboBox.setValue(listDataProvider.getItems().iterator().next());
		} else {
			comboBox.setEnabled(true);
		}
	}

}