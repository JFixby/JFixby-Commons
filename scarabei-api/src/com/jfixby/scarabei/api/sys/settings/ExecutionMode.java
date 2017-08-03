
package com.jfixby.scarabei.api.sys.settings;

public enum ExecutionMode {
	EARLY_DEVELOPMENT(3000), //
	TESTING(2000), //
	RELEASE_CANDIDATE(1000), //
	DEMO(500), //
	PUBLIC_RELEASE(0);//

	final private int level;

	ExecutionMode (final int level) {
		this.level = level;

	}

	public final boolean covers (final ExecutionMode targetMode) {
		return this.level >= targetMode.level;
	}

	public boolean isBelow (final ExecutionMode targetMode) {
		return this.level < targetMode.level;
	}

}
