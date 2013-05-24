package com.porotype.codelabel;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Main UI class
 */
@SuppressWarnings("serial")
@Theme("codelabel")
public class CodelabelUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final CodeLabel label = new CodeLabel("final VerticalLayout layout = new VerticalLayout();\nlayout.setMargin(true);\nsetContent(layout);\nlayout.setMargin(true);\nsetContent(layout);");
		layout.addComponent(label);
		
		final CheckBox linenums = new CheckBox("Line numbers",false);
		linenums.addValueChangeListener(new ValueChangeListener() {
			@Override
			public void valueChange(ValueChangeEvent event) {
				label.setLinenumsEnabled(linenums.getValue());
			}
		});
		layout.addComponent(linenums);
		
		Button b = new Button("Duplicate", new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				label.setValue(label.getValue() + label.getValue());
			}
		});
		layout.addComponent(b);
	}

}