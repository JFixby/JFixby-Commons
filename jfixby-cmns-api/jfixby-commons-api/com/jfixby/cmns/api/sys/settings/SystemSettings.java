
package com.jfixby.cmns.api.sys.settings;

import com.jfixby.cmns.api.ComponentInstaller;
import com.jfixby.cmns.api.assets.ID;

public class SystemSettings {

	static private ComponentInstaller<SystemSettingsComponent> componentInstaller = new ComponentInstaller<SystemSettingsComponent>(
		"TaskManager");

	public static final void installComponent (SystemSettingsComponent component_to_install) {
		componentInstaller.installComponent(component_to_install);
	}

	public static final SystemSettingsComponent invoke () {
		return componentInstaller.invokeComponent();
	}

	public static final SystemSettingsComponent component () {
		return componentInstaller.getComponent();
	}

	public static void setExecutionMode (ExecutionMode developer) {
		componentInstaller.invokeComponent().setExecutionMode(developer);
	}

	public static void setFlag (String flag_name, boolean flag_value) {
		invoke().setFlag(flag_name, flag_value);
	}

	public static boolean getFlag (String flag_name) {
		return invoke().getFlag(flag_name);
	}

	public static String getStringParameter (String parameter_name) {
		return invoke().getStringParameter(parameter_name);
	}

	public static void setLongParameter (String parameterName, long parameterValue) {
		invoke().setLongParameter(parameterName, parameterValue);
	}

	public static void setStringParameter (String parameter_name, String parameter_value) {
		invoke().setStringParameter(parameter_name, parameter_value);
	}

	public static void setSystemAssetID (String parameter_name, ID parameter_value) {
		invoke().setSystemAssetID(parameter_name, parameter_value);
	}

	public static ID getSystemAssetID (String parameter_name) {
		return invoke().getSystemAssetID(parameter_name);
	}

	public static void printSystemParameters () {
		invoke().printSystemParameters();
	}

	public static boolean executionModeCovers (ExecutionMode mode) {
		return invoke().executionModeCovers(mode);
	}

	public static ExecutionMode getExecutionMode () {
		return invoke().getExecutionMode();
	}

	public static long getLongParameter (String parameterName) {
		return invoke().getLongParameter(parameterName);
	}

}
