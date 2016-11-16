
package com.jfixby.red.android.net.http;

import com.jfixby.cmns.api.net.http.HttpCall;
import com.jfixby.cmns.api.net.http.HttpCallExecutor;
import com.jfixby.cmns.api.net.http.HttpCallParams;
import com.jfixby.cmns.api.net.http.HttpComponent;
import com.jfixby.cmns.api.net.http.HttpConnection;
import com.jfixby.cmns.api.net.http.HttpConnectionSpecs;
import com.jfixby.cmns.api.net.http.HttpFileSystem;
import com.jfixby.cmns.api.net.http.HttpFileSystemSpecs;
import com.jfixby.cmns.api.net.http.HttpURL;
import com.jfixby.red.filesystem.http.RedHttpFileSystem;
import com.jfixby.red.filesystem.http.RedHttpFileSystemSpecs;
import com.jfixby.red.net.RedHttpURL;

public class AndroidHttp implements HttpComponent {

	@Override
	public HttpURL newURL (final String url_string) {
		return new RedHttpURL(url_string);
	}

	@Override
	public HttpConnection newConnection (final HttpURL url) {
		return new AndroidHttpConnection(url, false);
	}

	@Override
	public HttpConnectionSpecs newConnectionSpecs () {
		return new AndroidHttpConnectionSpecs();
	}

	@Override
	public HttpConnection newConnection (final HttpConnectionSpecs specs) {
		final HttpURL url = specs.getURL();
		final boolean use_agent = specs.getUseAgent();
		return new AndroidHttpConnection(url, use_agent);
	}

	@Override
	public HttpCallParams newCallParams () {
		return new AndroidHttpCallParams();
	}

	@Override
	public HttpCallExecutor newCallExecutor () {
		return new AndroidCallExecutor();
	}

	@Override
	public HttpCall newCall (final HttpCallParams call_scecs) {
		return new AndroidCall(call_scecs);
	}

	@Override
	public HttpFileSystemSpecs newHttpFileSystemSpecs () {
		return new RedHttpFileSystemSpecs();
	}

	@Override
	public HttpFileSystem newHttpFileSystem (final HttpFileSystemSpecs specs) {
		return new RedHttpFileSystem(specs);
	}

}
