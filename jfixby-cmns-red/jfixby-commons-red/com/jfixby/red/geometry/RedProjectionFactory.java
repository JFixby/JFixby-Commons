
package com.jfixby.red.geometry;

import com.jfixby.cmns.api.geometry.IdentityProjection;
import com.jfixby.cmns.api.geometry.OffsetProjection;
import com.jfixby.cmns.api.geometry.ProjectionFactory;

public class RedProjectionFactory implements ProjectionFactory {

	private static final IdentityProjection E = new RedIdentityProjection();

	public RedProjectionFactory () {
	}

	@Override
	public OffsetProjection newOffset () {
		return new RedOffsetProjection();
	}

	@Override
	public IdentityProjection IDENTITY () {
		return E;
	}

}
