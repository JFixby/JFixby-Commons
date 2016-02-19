package com.jfixby.android.api;

import com.jfixby.cmns.api.ComponentInstaller;

public class Android {

	static private ComponentInstaller<AndroidComponent> componentInstaller = new ComponentInstaller<AndroidComponent>(
			"Android");

	public static final void installComponent(AndroidComponent component_to_install) {
		componentInstaller.installComponent(component_to_install);
	}

	public static final AndroidComponent invoke() {
		return componentInstaller.invokeComponent();
	}

	public static final AndroidComponent component() {
		return componentInstaller.getComponent();
	}

	public static long getMaxHeapSize() {
		return invoke().getMaxHeapSize();
	}

	public static long getRecommendedHeapSize() {
		return invoke().getRecommendedHeapSize();
	}

}