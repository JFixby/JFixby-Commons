package com.jfixby.red.desktop.test;

import com.jfixby.cmns.api.log.L;
import com.jfixby.red.desktop.DesktopAssembler;

public class PrimeSearch {

	static final public void main(String[] args) {
		DesktopAssembler.setup();
		long N = 1000;

		// L.d("array size", N * 1.0f / 1024 / 1024 / 1024 + " GB");

		boolean NOT_PRIME = true;

		BooleanArray array = new BooleanArray(N);
		long prime = 1;
		for (int i = 2; i < N; i++) {
			if (array.get(i) == false) {
				L.d("prime[" + prime + "]", i);
				prime++;
				long val = 2 * i;
				for (long k = 2; val < N;) {
					array.set((int) val, NOT_PRIME);
					k++;
					val = i * k;
				}
			}

		}

	}

}
