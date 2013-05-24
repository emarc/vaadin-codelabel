package com.porotype.codelabel.client.codelabel;

import com.google.gwt.dom.client.Element;
import com.vaadin.client.ui.VLabel;

public class CodeLabelWidget extends VLabel {

	public static final String CLASSNAME = "codelabel";
	public static final String CLASSNAME_PRETTIFY = "prettyprint";
	public static final String CLASSNAME_LINENUMS = "linenums";

	public CodeLabelWidget() {
		setStyleName(CLASSNAME);
	}

	public void setLinenumsEnabled(boolean linenumeEnabled) {
		if (linenumeEnabled) {
			getPreElement().addClassName(CLASSNAME_LINENUMS);
		} else {
			getPreElement().removeClassName(CLASSNAME_LINENUMS);
		}
	}
	
	protected Element getPreElement() {
		return getElement().getFirstChildElement();
	}
	
	public void  prettyPrint() {
		getPreElement().addClassName(CLASSNAME_PRETTIFY);
		jsPrettyPrint();
	}

	protected native void jsPrettyPrint()
	/*-{
	     $wnd.prettyPrint();
	 }-*/;

}