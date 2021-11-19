package com.sun.demo.model.response;

import com.sun.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harper
 * @date 2021/11/11
 * note:
 */
public class MultiResponse {

    private int type;
    private String content;
    private int drawableId;

    public MultiResponse(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public MultiResponse(int type, int drawableId) {
        this.type = type;
        this.drawableId = drawableId;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public static List<MultiResponse> getMultiResponse() {
        List<MultiResponse> responses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                responses.add(new MultiResponse(0, "我是MultiType的第" + i + "条"));
            } else {
                responses.add(new MultiResponse(1, R.mipmap.app_logo));
            }
        }
        return responses;
    }
}
