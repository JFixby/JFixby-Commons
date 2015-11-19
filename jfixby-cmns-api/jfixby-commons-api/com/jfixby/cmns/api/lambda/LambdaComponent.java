package com.jfixby.cmns.api.lambda;

public interface LambdaComponent {

	<X, Y> λFunction<X, Y> newFunction(λFunction<X, Y> exe);

	<X, Y> λFunction<X, Y> newFunction(λFunction<X, Y> exe, λFunctionCache<X, Y> graph);

	public <X, Y, Z> λFunction<X, Z> compose(λFunction<Y, Z> g, λFunction<X, Y> f);

}