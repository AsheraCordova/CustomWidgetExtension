package com.ashera.customwidgetextension;

public class CustomWidgetExtension  {
    public static void initPlugin() {
    	//start - widget
    	//end - widget
    	com.ashera.widget.WidgetFactory.registerAttributableFor("View", new CustomWidgetExtensionViewImpl());
    }
}
