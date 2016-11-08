
package com.jfixby.red.filesystem.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.jfixby.cmns.api.io.JavaInputStreamOperator;
import com.jfixby.cmns.api.java.ByteArray;
import com.jfixby.cmns.api.net.http.HttpURL;

public class HttpFileInputStreamOperator implements JavaInputStreamOperator {

	private final HttpFile v_file;

	public HttpFileInputStreamOperator (final HttpFile input_file) {
		this.v_file = input_file;
	}

	@Override
	public void closeStream () {
	}

	@Override
	public InputStream getJavaStream () throws IOException {
		final HttpFileSystem fs = this.v_file.getFileSystem();
		final HttpURL url = fs.getURLFor(this.v_file.getAbsoluteFilePath());
		final ByteArray data = HTTPOperator.readFile(url);
		return new ByteArrayInputStream(data.toArray());
	}

	@Override
	public boolean isReadAllSupported () {
		return true;
	}

	@Override
	public ByteArray readAll () throws IOException {
		final HttpFileSystem fs = this.v_file.getFileSystem();
		final HttpURL url = fs.getURLFor(this.v_file.getAbsoluteFilePath());
		final ByteArray data = HTTPOperator.readFile(url);
		return data;
	}

}
