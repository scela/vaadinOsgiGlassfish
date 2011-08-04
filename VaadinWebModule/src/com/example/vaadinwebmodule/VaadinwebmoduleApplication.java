package com.example.vaadinwebmodule;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.AbstractApplicationServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

import example.services.api.SimpleService;
import example2.ui.api.UiInterface;

public class VaadinwebmoduleApplication extends Application {
	String name;
	SimpleService simple;
	UiInterface ui;
	public VaadinwebmoduleApplication(String s,SimpleService simple,UiInterface ui) {
		// TODO Auto-generated constructor stub
	this.name=s;
	this.simple=simple;
	this.ui=ui;}
	
	@WebServlet(urlPatterns="/*")
	public static class Servlet extends AbstractApplicationServlet {

    @Resource(mappedName="decl-service-1")
	    SimpleService moduleService;
    
    @Resource(mappedName="decl-service-2")
    UiInterface uiInterface;

	    @Override
	    protected Class<? extends Application> getApplicationClass() {
	        return VaadinwebmoduleApplication.class;
	    }

	    @Override
	    protected Application getNewApplication(HttpServletRequest request)	throws ServletException {
	        return new VaadinwebmoduleApplication("kle4vis",moduleService,uiInterface);
	    }
	}

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadinwebmodule Application");
		Label label = new Label("Hello Vaadin user>>>>>>"+name+"<><><><><>"+simple.getString());
		mainWindow.addComponent(label);
		mainWindow.addComponent(ui.getComp());
		setMainWindow(mainWindow);
	}

}
