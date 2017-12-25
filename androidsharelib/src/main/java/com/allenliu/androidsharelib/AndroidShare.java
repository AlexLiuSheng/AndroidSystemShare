package com.allenliu.androidsharelib;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by allenliu on 2017/10/16.
 */

public class AndroidShare {
    private static final int REQUEST_CODE_ALLEN_SHARE = 0X666;
    private int platform;
    private ArrayList<Uri> imageUris;
    private String title;
    private String content;
    private Context context;
    private String systemShareTitle = "share";
    private AndroidShareListener shareListener;

    public void share() {
        try {
            share(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * dont set share listener,it is no useful
     * @param shareListener
     */
    @Deprecated
    public void share(AndroidShareListener shareListener) {
        this.shareListener = shareListener;
        Intent shareIntent = new Intent();
        shareIntent = getIntentByPlatform(shareIntent, platform);

        if (imageUris != null && imageUris.size() > 1) {
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        } else {
            shareIntent.setAction(Intent.ACTION_SEND);
            if (imageUris != null)
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUris.get(0));
        }
        if (title != null)
            shareIntent.putExtra(Intent.EXTRA_TITLE, title);
        if (content != null) {
            shareIntent.putExtra(Intent.EXTRA_TEXT, content);
            shareIntent.putExtra("Kdescription", content);
        }
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (imageUris != null)
            shareIntent.setType("image/*");
        else
            shareIntent.setType("text/*");
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(Intent.createChooser(shareIntent, systemShareTitle), REQUEST_CODE_ALLEN_SHARE);
        } else {
            context.startActivity(Intent.createChooser(shareIntent, systemShareTitle));
        }

    }

    private Intent getIntentByPlatform(Intent shareIntent, @AndroidSharePlatform.Platform int platform) {
        ComponentName comp = null;
        shareIntent.addCategory(Intent.CATEGORY_DEFAULT);
        switch (platform) {
            case AndroidSharePlatform.FACEBOOK:
                //com.facebook.composer.activity.ComposerActivity
                //com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias
                comp = new ComponentName("com.facebook.katana", "com.facebook.composer.shareintent.ImplicitShareIntentHandlerDefaultAlias");
                break;
            case AndroidSharePlatform.GMAIL:
                comp = new ComponentName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmailExternal");
                break;
            case AndroidSharePlatform.INSTAGRAM:
                comp = new ComponentName("com.instagram.android", "com.instagram.share.common.ShareHandlerActivity");
                break;
            case AndroidSharePlatform.QQ:
                comp = new ComponentName(
                        "com.tencent.mobileqq",
                        "com.tencent.mobileqq.activity.JumpActivity");
                break;
            case AndroidSharePlatform.QZONE:
                comp = new ComponentName(
                        "com.qzone",
                        "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
                break;
            case AndroidSharePlatform.SINA:
                comp = new ComponentName(
                        "com.sina.weibo",
                        "com.sina.weibo.composerinde.ComposerDispatchActivity");
                break;
            case AndroidSharePlatform.TWITTER:
                comp = new ComponentName("com.twitter.android", "com.twitter.composer.ComposerShareActivity");
                break;
            case AndroidSharePlatform.WECHAT:
                comp = new ComponentName("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareImgUI");
                break;
            case AndroidSharePlatform.WECHAT_TIMELINE:
                comp = new ComponentName("com.tencent.mm",
                        "com.tencent.mm.ui.tools.ShareToTimeLineUI");
                break;
            case AndroidSharePlatform.WHATSAPP:
                comp = new ComponentName("com.whatsapp", "com.whatsapp.ContactPicker");
                break;
            case AndroidSharePlatform.SYSTEMSHARE:
                break;
        }
        if (comp != null)
            shareIntent.setComponent(comp);
        return shareIntent;
    }

    public static class Builder {
        AndroidShare share;

        public Builder(Context context) {
            share = new AndroidShare();
            share.context = context;
        }

        public AndroidShare build() {
            return share;
        }

        public Builder setPlatform(@AndroidSharePlatform.Platform int platform) {
            share.platform = platform;
            return this;
        }

        public Builder setImageUri(Uri uri) {
            share.imageUris = new ArrayList<>();
            share.imageUris.add(uri);
            return this;
        }

        public Builder setImageUris(ArrayList<Uri> uris) {
            share.imageUris = new ArrayList<>();
            share.imageUris.addAll(uris);
            return this;
        }

        public Builder setTitle(String title) {
            share.title = title;
            return this;
        }

        public Builder setContent(String text) {
            share.content = text;
            return this;
        }

    }

    public static void onActivityResult(int requestCode, int resultCode, Intent data) {
         if(requestCode==REQUEST_CODE_ALLEN_SHARE){
             Log.e("shareLib","Share callback result code:"+resultCode+"");
             if(resultCode==Activity.RESULT_OK){

             }
         }
    }

}
