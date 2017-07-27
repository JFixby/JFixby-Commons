
package com.jfixby.scarabei.red.io;

import com.jfixby.scarabei.api.io.Buffer;
import com.jfixby.scarabei.api.java.ByteArray;
import com.jfixby.scarabei.api.util.Utils;

public class RedBuffer implements Buffer {

	private ByteArray bytes;

	public RedBuffer (ByteArray bytes) {
		this.bytes = bytes;

	}

	public RedBuffer () {
		this.bytes = Utils.newByteArray(0);
	}

	@Override
	public ByteArray getBytes () {
		return bytes;
	}
}
