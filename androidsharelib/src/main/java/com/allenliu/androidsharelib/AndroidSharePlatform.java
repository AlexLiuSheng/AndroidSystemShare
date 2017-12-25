package com.allenliu.androidsharelib;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by allenliu on 2017/10/16.
 */

public class AndroidSharePlatform {
    @IntDef({WECHAT, QQ, QZONE, WECHAT_TIMELINE, SINA, GMAIL, INSTAGRAM, FACEBOOK, WHATSAPP, TWITTER, SYSTEMSHARE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Platform {
    }

    public static final int WECHAT = 1;
    public static final int WECHAT_TIMELINE = 2;
    public static final int QQ = 3;
    public static final int QZONE = 4;
    public static final int SINA = 5;
    public static final int INSTAGRAM = 6;
    public static final int FACEBOOK = 7;
    public static final int WHATSAPP = 8;
    public static final int TWITTER = 9;
    public static final int GMAIL = 10;
    public static final int SYSTEMSHARE = 11;
}
