package de.ollie.tcjts.gui.vaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/**
 * The base class for the graphical user interface.
 *
 * @author ollie
 *
 */
@SpringUI
public class TCJTSUI extends UI {

	public static final Logger LOG = LoggerFactory.getLogger(TCJTSUI.class);

	final private CalcLayout calcLayout;

	public TCJTSUI(CalcLayout calcLayout) {
		super();
		this.calcLayout = calcLayout;
	}

	protected void init(final VaadinRequest request) {
		setContent(this.calcLayout);
	}

}