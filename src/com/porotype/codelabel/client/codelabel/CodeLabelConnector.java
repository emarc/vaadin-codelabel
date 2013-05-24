package com.porotype.codelabel.client.codelabel;

import com.porotype.codelabel.CodeLabel;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.label.LabelConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CodeLabel.class)
public class CodeLabelConnector extends LabelConnector {

	@Override
	public CodeLabelState getState() {
		return (CodeLabelState) super.getState();
	}

	@Override
	public CodeLabelWidget getWidget() {
		return (CodeLabelWidget) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		getWidget().setLinenumsEnabled(getState().linenums);

		getWidget().prettyPrint();
		
	}

}
