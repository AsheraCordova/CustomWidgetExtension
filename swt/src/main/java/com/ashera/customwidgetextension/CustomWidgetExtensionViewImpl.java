//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.ashera.customwidgetextension;
//start - imports
import java.util.*;

import r.android.content.Context;
import r.android.os.Build;
import r.android.view.View;
import r.android.annotation.SuppressLint;
import androidx.core.view.*;
import r.android.annotation.SuppressLint;

import com.ashera.widget.*;
import com.ashera.converter.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;
import static com.ashera.common.DisposeUtil.*;


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
		org.eclipse.swt.widgets.Control control = (org.eclipse.swt.widgets.Control) w.asNativeWidget();
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
		org.eclipse.swt.widgets.Control control = (org.eclipse.swt.widgets.Control) w.asNativeWidget();
		switch (key.getAttributeName()) {
		}
		return null;
	}
	
	

	// end - body
	private GradientPaintListener gradientPaintListener;
	private void setLinearGradientBackground(IWidget w, Object objValue) {
		Color color1 = (Color) ((java.util.List<Object>) objValue).get(0);
		Color color2 = (Color) ((java.util.List<Object>) objValue).get(1);
		Control control = (Control) w.asNativeWidget();
		
		if (gradientPaintListener != null) {
			control.removeListener(org.eclipse.swt.SWT.Resize, gradientPaintListener);
		}
		
		gradientPaintListener = new GradientPaintListener(control, color2, color1);
		control.addListener(org.eclipse.swt.SWT.Resize, gradientPaintListener);
		
		if (w.isInitialised()) {
			gradientPaintListener.handleEvent(null);
		}
	}
	
	private final class GradientPaintListener implements Listener {
		private final Control control;
		private final Color color2;
		private final Color color1;
	
		private GradientPaintListener(Control control, Color color2, Color color1) {
			this.control = control;
			this.color2 = color2;
			this.color1 = color1;
		}
	
		public void handleEvent(Event event) {
			if (control.getBackgroundImage() != null) {
				control.getBackgroundImage().dispose();
			}
			Rectangle rect = control.getBounds();
			Image newImage = new Image(control.getDisplay(), rect.width, rect.height);
			GC gc = new GC(newImage);
			gc.setForeground(color1);
			gc.setBackground(color2);
			gc.fillGradientRectangle(0, 0, rect.width, rect.height, true);
			gc.dispose();
			control.setBackgroundImage(newImage);
		}
	}
}
