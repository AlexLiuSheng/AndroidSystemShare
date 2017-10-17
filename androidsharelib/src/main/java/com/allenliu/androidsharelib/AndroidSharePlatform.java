package com.allenliu.androidsharelib;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by allenliu on 2017/10/16.
 */

public class AndroidSharePlatform {
    @IntDef({WECHAT, QQ, QZONE, WECHAT_TIMELINE, SINA, GMAIL, INSTAGRAM, FACEBOOK, WHATSAPP, TWITTER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Platform {
    }

    public static final int WECHAT = 1;
    public static final int QQ = 2;
    public static final int QZONE = 3;
    public static final int WECHAT_TIMELINE = 4;
    public static final int SINA = 5;
    public static final int GMAIL = 6;
    public static final int INSTAGRAM = 7;
    public static final int FACEBOOK = 8;
    public static final int WHATSAPP = 9;
    public static final int TWITTER = 10;
}
