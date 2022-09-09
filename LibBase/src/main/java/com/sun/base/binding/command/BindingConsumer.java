package com.sun.base.binding.command;

/**
 * @param <T> the first argument type
 * @author: Harper
 * @date: 2022/9/8
 * @note: A one-argument action.
 */
public interface BindingConsumer<T> {
    void call(T t);
}
