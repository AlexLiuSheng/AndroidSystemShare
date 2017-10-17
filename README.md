# AndroidSystemShare
a multitype share library base android system share
## include
```
compile 'com.allenliu:AndroidSystemShare:1.0.0'
```
### useage
```
 AndroidShare share = new AndroidShare
                .Builder(this)
                .setPlatform(AndroidSharePlatform.INSTAGRAM)
                .setImageUris(imageUris)
                .setContent("test")
                .build();
        share.share();
```
- support 11 platforms share
- support multitype share