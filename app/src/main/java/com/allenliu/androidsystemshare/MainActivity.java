package com.allenliu.androidsystemshare;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allenliu.androidsharelib.AndroidShare;
import com.allenliu.androidsharelib.AndroidSharePlatform;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Uri> imageUris = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
//            if(i==0)
            imageUris.add(Uri.fromFile(new File("/storage/emulated/0/sina/weibo/weibo/img-43409e54deb4bef7a89d9f6f8fd98262.jpg")));
//            else
//            imageUris.add(Uri.fromFile(new File("/storage/emulated/0/sina/weibo/weibo/img-2.jpg")));

//        imageUris.add(Uri.fromFile(new File("/storage/emulated/0/Tencent/QQ_Images/-525b995ca35ecc2c.jpg")));
        }
        AndroidShare share = new AndroidShare
                .Builder(this)
                .setPlatform(AndroidSharePlatform.GMAIL)
                .setImageUris(imageUris)
                .setContent("test")
                .setTitle("title")
                .build();
        share.share();

    }
}
