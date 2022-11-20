package com.ashera.customwidgetextension;

import com.ashera.widget.WidgetFactory;

public class CustomWidgetExtension  {
    public static void initPlugin() {
    	//start - body
    	//end - body
    	WidgetFactory.registerAttributableFor("view", new CustomWidgetExtensionViewImpl());
    }
}
