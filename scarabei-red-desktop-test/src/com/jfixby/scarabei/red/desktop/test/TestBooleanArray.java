
package com.jfixby.scarabei.red.desktop.test;

import com.jfixby.scarabei.api.desktop.DesktopSetup;
import com.jfixby.scarabei.api.log.L;

public class TestBooleanArray {

	public static void main (String[] args) {
		DesktopSetup.deploy();
		int N = 170;
		BooleanArray array = new BooleanArray(N);

		for (int i = 0; i < N; i++) {
			array.set(i, false);
		}

		L.d("array", array);

	}

}