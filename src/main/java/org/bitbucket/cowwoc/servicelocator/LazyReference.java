/*
 * Copyright 2014 Gili Tzabari.
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package org.bitbucket.cowwoc.servicelocator;

/**
 * A reference that initializes a single value on demand.
 * <p>
 * The implementation is not thread-safe.
 * <p>
 * @author Gili Tzabari
 * @param <T> the type of object being referenced
 */
public abstract class LazyReference<T> implements ValueGenerator<T>
{
	/**
	 * True if the value was created.
	 */
	private boolean initialized;
	/**
	 * The value. This variable uses <a href="http://stackoverflow.com/a/6169551/14731">piggybacking
	 * synchronization</a>.
	 */
	private T value;

	/**
	 * Creates the value. This method is invoked the first time {@link #getValue()} is invoked.
	 * <p>
	 * @return the value
	 */
	protected abstract T createValue();

	/**
	 * @return true if the value was initialized
	 */
	public boolean isInitialized()
	{
		return initialized;
	}

	@Override
	public T getValue()
	{
		if (!initialized)
		{
			this.value = createValue();
			initialized = true;
		}
		return this.value;
	}
}
