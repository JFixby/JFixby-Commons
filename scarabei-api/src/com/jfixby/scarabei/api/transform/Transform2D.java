
package com.jfixby.scarabei.api.transform;

import com.jfixby.scarabei.api.ComponentInstaller;

public class Transform2D {

	static private ComponentInstaller<Transform2DComponent> componentInstaller = new ComponentInstaller<Transform2DComponent>(
		"Transform2D");

	public static final void installComponent (final Transform2DComponent component_to_install) {
		componentInstaller.installComponent(component_to_install);
	}

	public static final Transform2DComponent invoke () {
		return componentInstaller.invokeComponent();
	}

	public static final Transform2DComponent component () {
		return componentInstaller.getComponent();
	}

	public static RectangleTransform newRectangleTransform () {
		return invoke().newRectangleTransform();
	}
}
