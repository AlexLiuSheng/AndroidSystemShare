## AndroidSystemShare [ ![Download](https://api.bintray.com/packages/zkxy/maven/AndroidSystemShare/images/download.svg) ](https://bintray.com/zkxy/maven/AndroidSystemShare/_latestVersion) <a href="http://www.methodscount.com/?lib=com.allenliu%3AAndroidSystemShare%3A1.0.1"><img src="https://img.shields.io/badge/Methods and size-core: 40 | deps: 18650 | 20 KB-e91e63.svg"/></a>
A sharing library supports text and multiple images based on android system sharing.This library is tiny because it uses android internal sharing function.
Library is very useful when developers only need to share image or text to a certain platform or platforms,
and do not care about the result of sharing. 

### GIF SHOW

<img src="https://github.com/AlexLiuSheng/AndroidSystemShare/blob/master/ui/ui.gif" width=300/>

### include
```
compile 'com.allenliu:AndroidSystemShare:1.0.1'
```
### usage
```
 AndroidShare share = new AndroidShare
                .Builder(this)
                .setPlatform(AndroidSharePlatform.INSTAGRAM)
                .setImageUris(imageUris)
                .setContent("test")
                .build();
        share.share();
```
- support 11 platforms sharing
   - [x] WECHAT
   - [X] WECHAT_TIMELINE
   - [X] QQ
   - [X] QZONE
   - [X] SINA 
   - [X] INSTAGRAM
   - [X] FACEBOOK
   - [X] WHATSAPP
   - [X] TWITTER
   - [X] GMAIL
   - [X] SYSTEMSHARE
- support multiple types sharing


   | platform | pure text |  image  | multi images |
   | ------------- |:-------------|:-------------|:-------------:|
   | WECHAT        | Y          | Y                | Y         |
   | WECHAT_TIMELINE  | N          | Y                | Y         |
   | QQ           | Y          | Y                | Y             |
   | QZONE        | Y          | Y                | Y             |
   | SINA         | Y          | Y                | Y             |
   | INSTAGRAM    | N          | Y                | N             |
   | FACEBOOK     | N          | Y                | Y             |
   | WHATSAPP     | Y          | Y                | Y             |
   | TWITTER      | Y          | Y                | N             |
   | GMAIL        | N          | Y                | Y             |
   | SYSTEMSHARE  | -          | -                |-              |
   

  
### License 

  Apache 2.0

