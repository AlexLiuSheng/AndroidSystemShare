package com.allenliu.androidsystemshare;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.allenliu.androidsharelib.AndroidShare;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStart;
    private EditText etShareContent;
    private AppCompatSpinner platformSpinner, shareTypeSpinner;
    private int currentPlatForm;
    private int shareType;
    private final int PURE_TEXT = 1, SINGLE_IMAGE = 2, MULTI_IMAGES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        btnStart = findViewById(R.id.btnShare);
        etShareContent = findViewById(R.id.et_content);
        platformSpinner = findViewById(R.id.plat_spinner);
        shareTypeSpinner = findViewById(R.id.sharetype_spinner);
        btnStart.setOnClickListener(this);
        platformSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.platForms)));
        shareTypeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.shareType)));
        platformSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                currentPlatForm = pos + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        shareTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                shareType = i + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        String shareContent = etShareContent.getText().toString().trim();
        ArrayList<Uri> imageUris = new ArrayList<>();
        int loopCount = 0;
        if (shareType == SINGLE_IMAGE)
            loopCount = 1;
        else if (shareType == MULTI_IMAGES)
            loopCount = 2;
        //replace follow image uri with your own test uri
        for (int i = 0; i < loopCount; i++) {
            if (i == 0)
                imageUris.add(Uri.fromFile(new File("/storage/emulated/0/sina/weibo/weibo/img-43409e54deb4bef7a89d9f6f8fd98262.jpg")));
            else
                imageUris.add(Uri.fromFile(new File("/storage/emulated/0/Pictures/Screenshots/Screenshot_20171219-095511.jpg")));
        }
        AndroidShare.Builder shareBuilder = new AndroidShare
                .Builder(this)
                .setPlatform(currentPlatForm)
                .setContent(shareContent)
                .setTitle("title");
        if (shareType != PURE_TEXT)
            shareBuilder.setImageUris(imageUris);
        shareBuilder.build().share();
    }


}
