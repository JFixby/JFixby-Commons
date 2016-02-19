package com.jfixby.cmns.api.java.gc;

import com.jfixby.cmns.api.ComponentInstaller;

public class GCFisher {

	public static final String DefaultBaitSize = "DefaultBaitSize";

	static private ComponentInstaller<GCFisherComponent> componentInstaller = new ComponentInstaller<GCFisherComponent>(
			"GCFisher");

	public static final void installComponent(GCFisherComponent component_to_install) {
		componentInstaller.installComponent(component_to_install);
	}

	public static final GCFisherComponent invoke() {
		return componentInstaller.invokeComponent();
	}

	public static final GCFisherComponent component() {
		return componentInstaller.getComponent();
	}

	public static void onBaitCaptured(Bait bait) {
		invoke().onBaitCaptured(bait);
	}

	public static BaitInfo throwBait(int size_in_MB) {
		return invoke().throwBait(size_in_MB);
	}

	public static BaitInfo throwBait() {
		return invoke().throwBait();
	}

}