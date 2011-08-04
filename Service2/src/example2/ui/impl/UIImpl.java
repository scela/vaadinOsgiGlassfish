package example2.ui.impl;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

import example2.ui.api.UiInterface;

public class UIImpl implements UiInterface {

	@Override
	public String getCaption() {
		// TODO Auto-generated method stub
		return "Button nga osgi";
	}

	@Override
	public Component getComp() {
		// TODO Auto-generated method stub
		return new Button(getCaption());
	}

}
