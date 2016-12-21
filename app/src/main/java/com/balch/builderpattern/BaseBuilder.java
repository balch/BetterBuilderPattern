package com.balch.builderpattern;

public abstract class BaseBuilder<T> {
    protected T data;

    /**
     * Constructor that accepts instantiated data object.
     * @param data
     */
    public BaseBuilder(T data) {
        this.data = data;
    }

    /**
     * Pass back the created object and prevent class from modifying it further
     * @return
     */
    public T build() {
        T value = data;
        // discard built user object
        data = null;
        return value;
    }
}

