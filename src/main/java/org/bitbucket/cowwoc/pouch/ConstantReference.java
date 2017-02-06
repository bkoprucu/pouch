/*
 * Copyright 2014 Gili Tzabari.
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.pouch;

/**
 * A {@code Reference} that returns a pre-existing value.
 * <p>
 * The implementation is thread-safe.
 * <p>
 * @author Gili Tzabari
 * @param <T> the type of value returned by the reference
 */
public final class ConstantReference<T> implements Reference<T>
{
	private final T value;

	/**
	 * Creates a new ConstantReference.
	 * <p>
	 * @param value the value
	 */
	public ConstantReference(T value)
	{
		this.value = value;
	}

	@Override
	public T getValue() throws IllegalStateException
	{
		return value;
	}

	@Override
	public boolean isInitialized()
	{
		return true;
	}
}
