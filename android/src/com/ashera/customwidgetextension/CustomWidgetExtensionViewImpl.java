package com.ashera.customwidgetextension;
//start - imports
import java.util.*;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.annotation.SuppressLint;
import androidx.core.view.*;
import android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;
import android.widget.*;
import android.view.*;
import android.graphics.*;
import android.content.res.*;


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
		switch (key.getAttributeName()) {
		}
		return null;
	}
	
	

	
private CustomWidgetExtensionViewCommandBuilder builder;
private CustomWidgetExtensionViewBean bean;
public CustomWidgetExtensionViewBean getBean() {
	if (bean == null) {
		bean = new CustomWidgetExtensionViewBean();
	}
	return bean;
}
public CustomWidgetExtensionViewCommandBuilder getBuilder() {
	if (builder == null) {
		builder = new CustomWidgetExtensionViewCommandBuilder();
	}
	return builder;
}


public  class CustomWidgetExtensionViewCommandBuilder extends com.ashera.layout.ViewImpl.ViewCommandBuilder <CustomWidgetExtensionViewCommandBuilder> {
    public CustomWidgetExtensionViewCommandBuilder() {
	}
	
	public CustomWidgetExtensionViewCommandBuilder execute(boolean setter) {
		if (setter) {
			w.executeCommand(command, null, IWidget.COMMAND_EXEC_SETTER_METHOD);
			w.getFragment().remeasure();
		}
		w.executeCommand(command, null, IWidget.COMMAND_EXEC_GETTER_METHOD);
return this;	}

public CustomWidgetExtensionViewCommandBuilder setLinearGradientBackground(String value) {
	Map<String, Object> attrs = initCommand("linearGradientBackground");
	attrs.put("type", "attribute");
	attrs.put("setter", true);
	attrs.put("orderSet", ++orderSet);

	attrs.put("value", value);
return this;}
}
public class CustomWidgetExtensionViewBean extends com.ashera.layout.ViewImpl.ViewBean{
		public CustomWidgetExtensionViewBean() {
			super(CustomWidgetExtensionViewImpl.this.w);
		}
public void setLinearGradientBackground(String value) {
	getBuilder().reset().setLinearGradientBackground(value).execute(true);
}

}


	// end - body


private void setLinearGradientBackground(IWidget w, Object objValue) {
	View v = (View) w.asNativeWidget();
	int[] colors = { (Integer) ((List<Object>) objValue).get(0), (Integer) ((List<Object>) objValue).get(1) };
	// create a new gradient color
	android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colors);
	gd.setCornerRadius(0f);
	v.setBackground(gd);	
}
}
