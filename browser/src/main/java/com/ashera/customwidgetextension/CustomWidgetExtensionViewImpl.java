package com.ashera.customwidgetextension;
//start - imports
import java.util.*;

import r.android.content.Context;
import r.android.os.Build;
import r.android.view.View;
import r.android.annotation.SuppressLint;
import r.android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;


import static com.ashera.widget.IWidget.*;
//end - imports
public class CustomWidgetExtensionViewImpl implements com.ashera.widget.IAttributable {
	// start - body
	public final static String LOCAL_NAME = "CustomWidgetExtensionView"; 
	private IWidget w;
	private CustomWidgetExtensionViewImpl(IWidget widget) {
		this.w = widget;
	}
	
	public String getLocalName() {
		return LOCAL_NAME;
	}
	
	public CustomWidgetExtensionViewImpl() {
	}
	
	@Override
	public com.ashera.widget.IAttributable newInstance(IWidget widget) {
		CustomWidgetExtensionViewImpl newIntance = new CustomWidgetExtensionViewImpl(widget);
		
		return newIntance;
	}
	
	
	@SuppressLint("NewApi")
	@Override
	public void loadAttributes(String localName) {

		WidgetFactory.registerAttribute(localName, new WidgetAttribute.Builder().withName("linearGradientBackground").withType("array").withArrayType("color"));
	}

	@SuppressLint("NewApi")
	@Override
	public void setAttribute(WidgetAttribute key, String strValue, Object objValue, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		org.teavm.jso.dom.html.HTMLElement hTMLElement = (org.teavm.jso.dom.html.HTMLElement) w.asNativeWidget();
		switch (key.getAttributeName()) {
		case "linearGradientBackground": {


		setLinearGradientBackground(w, objValue);



			}
			break;
		default:
			break;
		}
	}
	
	@SuppressLint("NewApi")
	@Override
	public Object getAttribute(WidgetAttribute key, ILifeCycleDecorator decorator) {
		View view = (View) w.asWidget();
		org.teavm.jso.dom.html.HTMLElement hTMLElement = (org.teavm.jso.dom.html.HTMLElement) w.asNativeWidget();
		switch (key.getAttributeName()) {
		}
		return null;
	}
	
	

	// end - body

	private void setLinearGradientBackground(IWidget w, Object objValue) {
		String color1 = (String) ((java.util.List<Object>) objValue).get(0);		
		String color2 = (String) ((java.util.List<Object>) objValue).get(1);
		org.teavm.jso.dom.html.HTMLElement htmlElement = (org.teavm.jso.dom.html.HTMLElement) w.asNativeWidget();
		htmlElement.getStyle().setProperty("background-image", "linear-gradient(" + color1 + "," +color2 + ")");
	}
}
