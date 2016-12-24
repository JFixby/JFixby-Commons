
package com.jfixby.scarabei.red.util.md5;

import java.io.IOException;

import com.jfixby.scarabei.api.debug.Debug;
import com.jfixby.scarabei.api.io.Buffer;
import com.jfixby.scarabei.api.io.BufferInputStream;
import com.jfixby.scarabei.api.io.IO;
import com.jfixby.scarabei.api.java.ByteArray;
import com.jfixby.scarabei.api.md5.MD5Component;
import com.jfixby.scarabei.api.util.JUtils;

public abstract class RedMD5 implements MD5Component {

	@Override
	public String md5String (final String password) {
		Debug.checkNull("input", password);
		try {
			final ByteArray array = JUtils.newByteArray(password.getBytes());
			final Buffer buff = IO.newBuffer(array);
			final BufferInputStream bis = IO.newBufferInputStream(buff);
			bis.open();
			final String result = this.md5Stream(bis);
			bis.close();
			return result;
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}