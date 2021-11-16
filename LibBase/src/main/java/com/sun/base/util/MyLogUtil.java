package com.sun.base.util;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.DiskLogStrategy;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.sun.base.bean.DiskLogHandler;
import com.sun.base.bean.LogLevel;


/**
 * @author: Harper
 * @date: 2021/11/12
 * @note: 自定义 打印日志工具
 */
public final class MyLogUtil {
    /**
     * 默认日志tag <br/>
     */
    private static final String TAG = "MyLogUtil";

    /**
     * 默认提供打印服务
     */
    private static boolean mIsAbleLog = true;

    public static final int V = 0;
    public static final int I = 1;
    public static final int D = 2;
    public static final int W = 3;
    public static final int E = 4;

    private static int logLevel = V;

    public static void log(LogLevel level, String tag, String message) {
        switch (level.ordinal()) {
            case V:
                v(tag, message);
                break;
            case I:
                i(tag, message);
                break;
            case D:
                d(tag, message);
                break;
            case W:
                w(tag, message);
                break;
            case E:
                e(tag, message);
                break;
            default:
                d(tag, message);
                break;
        }
    }


    public static void log(LogLevel level, String message) {
        switch (level.ordinal()) {
            case V:
                v(message);
                break;
            case I:
                i(message);
                break;
            case D:
                d(message);
                break;
            case W:
                w(message);
                break;
            case E:
                e(message);
                break;
            default:
                d(message);
                break;
        }
    }

    /**
     * 打印 verbose级别
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        try {
            if (mIsAbleLog && logLevel < V) {
                Logger.t(tag).v(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 verbose级别
     *
     * @param msg
     */
    public static void v(String msg) {
        try {
            if (mIsAbleLog && logLevel < V) {
                Logger.v(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 info级别
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        try {
            if (mIsAbleLog && logLevel < I) {
                Logger.t(tag).i(msg);
            }
        } catch (Exception e) {

        }

    }

    public static void i(String msg) {
        try {
            if (mIsAbleLog && logLevel < I) {
                Logger.i(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 debug级别
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        try {
            if (mIsAbleLog && logLevel < D) {
                Logger.t(tag).d(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 debug级别
     *
     * @param msg
     */
    public static void d(String msg) {
        try {
            if (mIsAbleLog && logLevel < D) {
                Logger.d(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 warn级别
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        try {
            if (mIsAbleLog && logLevel < W) {
                Logger.t(tag).w(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 warn级别
     *
     * @param msg
     */
    public static void w(String msg) {
        try {
            if (mIsAbleLog && logLevel < W) {
                Logger.w(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 warn级别
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg, Throwable e) {
        if (mIsAbleLog && logLevel < W) {
            Logger.t(tag).e(e, msg);
        }
    }


    /**
     * 打印 error级别
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        try {
            if (mIsAbleLog && logLevel < E) {
                Logger.t(tag).e(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 error级别
     *
     * @param msg
     */
    public static void e(String msg) {
        try {
            if (mIsAbleLog && logLevel < E) {
                Logger.e(msg);
            }
        } catch (Exception e) {

        }
    }

    /**
     * 打印 error级别
     *
     * @param tag
     * @param msg
     * @param e
     */
    public static void e(String tag, String msg, Throwable e) {
        if (mIsAbleLog && logLevel < E) {
            Logger.t(tag).e(e, msg);
        }
    }

    public static void json(String tag, String msg) {
        if (mIsAbleLog && logLevel < D) {
            Logger.t(tag).json(msg);
        }
    }

    public static void json(String msg) {
        if (mIsAbleLog && logLevel < D) {
            Logger.json(msg);
        }
    }

    /**
     * 设置打印等级
     *
     * @param level
     */
    public static void setLogLevel(int level) {
        logLevel = level;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context, final boolean isEnableAndroidLog) {
        setAndroidLog(isEnableAndroidLog);
        setDiskLog(context);
    }

    /**
     * 设置打印日志到Android控制台（Console）
     *
     * @param isEnableAndroidLog 是否开启
     */
    private static void setAndroidLog(final boolean isEnableAndroidLog) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                    .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isEnableAndroidLog;
            }
        });
    }

    /**
     * 设置打印日志到本地
     *
     * @param appContext
     */
    private static void setDiskLog(Context appContext) {
        //添加日志输出到本地功能
        // 日志输出文件夹路径
        String logFolderPath = FileUtil.getExternalFilesDir(appContext, DiskLogHandler.DEFAULT_LOG_DIR_NAME)
                .getAbsolutePath();
        //单个日志文件最大大小
        long maxPerLogFileSize = DiskLogHandler.DEFAULT_MAX_FILE_BYTES;
        //日志文件夹输出最大大小
        long maxLogFolderSize = DiskLogHandler.DEFAULT_MAX_FOLDER_BYTES;
        LogStrategy diskLogStrategy = new DiskLogStrategy(new DiskLogHandler(logFolderPath, maxPerLogFileSize, maxLogFolderSize));
        // (Optional) Global tag for every log. Default PRETTY_LOGGER
        CsvFormatStrategy csvFormatStrategy = CsvFormatStrategy.newBuilder()
                .logStrategy(diskLogStrategy)
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new DiskLogAdapter(csvFormatStrategy));
    }
}
