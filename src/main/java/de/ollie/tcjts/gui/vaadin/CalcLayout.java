package de.ollie.tcjts.gui.vaadin;

import org.springframework.stereotype.Component;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;

import de.ollie.utils.configuration.ProjectConfiguration;
import de.ollie.utils.gui.vaadin.LayoutUtil;
import de.ollie.utils.localization.LocalizationManager;
import de.ollie.utils.localization.SupportedLanguage;

/**
 * The main layout for the calculator.
 * 
 * @author ollie
 *
 */
@Component
public class CalcLayout extends VerticalLayout {

	private final LocalizationManager localizationManager;
	private final ProjectConfiguration projectConfiguration;

	private SupportedLanguage language = SupportedLanguage.DE;

	/**
	 * Creates a new main layout component.
	 * 
	 * @param localizationManager  A reference to a localization manager.
	 * @param projectConfiguration A configuration for the project data.
	 */
	public CalcLayout(LocalizationManager localizationManager, ProjectConfiguration projectConfiguration) {
		super();
		this.localizationManager = localizationManager;
		this.projectConfiguration = projectConfiguration;
		setMargin(true);
		addComponent(createHeaderLayout());
		addComponent(createControlLayout());
		addComponent(createPositionLayout());
	}

	private Layout createHeaderLayout() {
		Layout layout = new VerticalLayout();
		layout.setSizeFull();
		Label label = new Label("<H1><B>" + this.getResourceStr("application.title") + "</B></H1>", ContentMode.HTML);
		label.setCaptionAsHtml(true);
		layout.addComponent(label);
		String projectVersion = this.projectConfiguration.getVersion();
		layout.addComponent(new Label(this.getResourceStr("application.version").replace("{0}",
				(projectVersion != null ? projectVersion : "k. A."))));
		layout.addComponent(LayoutUtil.createVerticalLine(1, (int) getWidth()));
		return layout;
	}

	private Layout createControlLayout() {
		Layout layout = new VerticalLayout();
		layout.setSizeFull();
		Layout subLayout = new HorizontalLayout();
		Label label = new Label("Controls");
		subLayout.addComponent(label);
		layout.addComponent(subLayout);
		return layout;
	}

	private Layout createPositionLayout() {
		Layout layout = new VerticalLayout();
		layout.setSizeFull();
		Label label = new Label("Positions");
		layout.addComponent(label);
		return layout;
	}

	private String getResourceStr(String resourceId) {
		return this.localizationManager.getText(resourceId, this.language);
	}

}