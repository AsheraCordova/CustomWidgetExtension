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

/*-[
#include <UIKit/UIKit.h>
#include "ASUIView.h"
]-*/
import com.google.j2objc.annotations.Property;
import androidx.core.view.*;

import static com.ashera.widget.IWidget.*;
//end - imports
import com.ashera.widget.bus.Event.StandardEvents;
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
		Object nativeWidget = w.asNativeWidget();
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
		Object nativeWidget = w.asNativeWidget();
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
	private PostMeasureEventHandler postMeasureEventHandler;
	private void setLinearGradientBackground(IWidget w, Object objValue) {
		Object color1 = ((java.util.List<Object>) objValue).get(0);
		Object color2 = ((java.util.List<Object>) objValue).get(1);

		nativeSetLinearGradientBackground(w.asNativeWidget(), color1, color2);
		
		String postMeasureEvent = StandardEvents.postMeasure.toString();
		if (postMeasureEventHandler == null) {
			postMeasureEventHandler = new PostMeasureEventHandler(postMeasureEvent, w);
			w.getFragment().getEventBus().on(postMeasureEvent, postMeasureEventHandler);
		}

	}
	
    @com.google.j2objc.annotations.WeakOuter
	final static class PostMeasureEventHandler extends com.ashera.widget.bus.EventBusHandler {

		private IWidget widget;

		public PostMeasureEventHandler(String type, IWidget widget) {
			super(type);
			this.widget = widget;
		}

		@Override
		protected void doPerform(Object payload) {
			nativeSetFrameForCAGradientLayer(widget.asNativeWidget());
		}
		
	}
    
    public static native void nativeSetFrameForCAGradientLayer(Object nativeWidget)/*-[
    	UIView* view = ((UIView*)nativeWidget);
    	for (CALayer *layer in view.layer.sublayers) {
	    	if ([layer isKindOfClass:[CAGradientLayer class]]) {
	      		layer.frame = CGRectMake(0, 0, view.bounds.size.width, view.bounds.size.height);
	      	}
	    }
    ]-*/;
	public static native void nativeSetLinearGradientBackground(Object nativeWidget, Object color1, Object color2)/*-[
	  UIView* view = ((UIView*)nativeWidget);
	  CAGradientLayer *gradient = [CAGradientLayer layer];
	  gradient.colors = @[(id)((UIColor*) color1).CGColor, (id)((UIColor*) color2).CGColor];
	  for (CALayer *layer in view.layer.sublayers) {
	    if ([layer isKindOfClass:[CAGradientLayer class]]) {
	      [layer removeFromSuperlayer];
	    }
	  }
	  [view.layer insertSublayer:gradient atIndex:0];
		
	]-*/;
}
