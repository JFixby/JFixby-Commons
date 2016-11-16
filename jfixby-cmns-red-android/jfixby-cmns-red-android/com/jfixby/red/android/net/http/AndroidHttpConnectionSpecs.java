package com.jfixby.red.android.net.http;

import com.jfixby.cmns.api.net.http.HttpConnectionSpecs;
import com.jfixby.cmns.api.net.http.HttpURL;

public class AndroidHttpConnectionSpecs implements HttpConnectionSpecs {

	private HttpURL url;
	private boolean agent;

	@Override
	public void setURL(HttpURL url) {
		this.url = url;
	}

	@Override
	public void setUseAgent(boolean agent) {
		this.agent = agent;
	}

	@Override
	public HttpURL getURL() {
		return url;
	}

	@Override
	public boolean getUseAgent() {
		return agent;
	}

}
