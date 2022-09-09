package com.sun.base.http.interceptor.logging;


import java.util.logging.Level;

import okhttp3.internal.platform.Platform;

/**
 * @author: Harper
 * @date: 2022/9/9
 * @note:
 */
class I {

    protected I() {
        throw new UnsupportedOperationException();
    }

    static void log(int type, String tag, String msg) {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(tag);
        if (type == Platform.INFO) {
            logger.log(Level.INFO, msg);
        } else {
            logger.log(Level.WARNING, msg);
        }
    }
}
