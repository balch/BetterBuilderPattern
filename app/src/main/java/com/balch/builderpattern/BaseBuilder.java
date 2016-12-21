package com.balch.builderpattern;

public abstract class BaseBuilder<T> {
    protected T data;

    /**
     * Constructor that allows for data object in creating using parameters passed into
     * the base class constructor
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

