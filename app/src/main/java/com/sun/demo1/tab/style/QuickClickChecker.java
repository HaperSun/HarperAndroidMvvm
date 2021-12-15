package com.sun.demo1.tab.style;

/**
 * @author: Harper
 * @date: 2021/12/15
 * @note:
 */
public class QuickClickChecker {
    private int threshold;
    private long lastClickTime = 0;

    public QuickClickChecker(int threshold) {
        this.threshold = threshold;
    }

    public boolean isQuick() {
        boolean isQuick = System.currentTimeMillis() - lastClickTime <= threshold;
        lastClickTime = System.currentTimeMillis();
        return isQuick;
    }
}
