package com.sun.base.binding.command;

/**
 * @param <T> the result type
 * @author: Harper
 * @date: 2022/9/8
 * @note: Represents a function with zero arguments.
 */
public interface BindingFunction<T> {
    T call();
}
