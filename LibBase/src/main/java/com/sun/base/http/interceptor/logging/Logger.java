package com.sun.base.http.interceptor.logging;

import okhttp3.internal.platform.Platform;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface Logger {
    void log(int level, String tag, String msg);

    Logger DEFAULT = new Logger() {
        @Override
        public void log(int level, String tag, String message) {
            Platform.get().log(level, message, null);
        }
    };
}
