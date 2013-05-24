package com.porotype.codelabel;

import java.util.logging.Logger;

import com.google.debugging.sourcemap.dev.protobuf.DescriptorProtos.FieldDescriptorProto.Label;
import com.porotype.codelabel.client.codelabel.CodeLabelState;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.data.Property;
import com.vaadin.shared.ui.label.ContentMode;

/**
 * A {@link Label} that presents the source code it's given as value (text) in a
 * formatted, colored manner.
 * <p>
 * The {@link CodeLabel} only supports the PREFORMATTED {@link ContentMode}. >p>
 * 
 */
@JavaScript({ "theme://../codelabel/prettify.js" })
@StyleSheet({ "theme://../codelabel/prettify.css" })
public class CodeLabel extends com.vaadin.ui.Label {

	public CodeLabel(Property contentSource) {
		super(contentSource);
		super.setContentMode(ContentMode.PREFORMATTED);
	}

	public CodeLabel(String content) {
		super(content);
		super.setContentMode(ContentMode.PREFORMATTED);
	}

	public CodeLabel() {
		super.setContentMode(ContentMode.PREFORMATTED);
	}

	@Override
	public void setContentMode(ContentMode contentMode) {
		Logger.getLogger(CodeLabel.class.getName()).warning(
				CodeLabel.class.getSimpleName()
						+ " does not support ContentMode");
	}

	@Override
	public CodeLabelState getState() {
		return (CodeLabelState) super.getState();
	}

	/**
	 * Enables or disables line numbering. When enabled, line numbers are by
	 * default shown every 5th row.
	 * 
	 * @param linenumsEnabled
	 */
	public void setLinenumsEnabled(boolean linenumsEnabled) {
		getState().linenums = linenumsEnabled;
	}

	public boolean isLinenumsEnabled() {
		return getState().linenums;
	}
}
