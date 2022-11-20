package com.ashera.customwidgetextension;

public class CustomWidgetExtension  {
    public static void initPlugin() {
    	//start - body
    	//end - body
    	com.ashera.widget.WidgetFactory.registerAttributableFor("View", new CustomWidgetExtensionViewImpl());
    }
}
