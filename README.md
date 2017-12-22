# AndroidSystemShare
a  sharing library with multiple types base on android system sharing
## include
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
   | WECHAT_TIMELINE  | Y          | Y                | Y         |
   | QQ           | Y          | Y                | Y             |
   | QZONE        | Y          | Y                | Y             |
   | SINA         | Y          | Y                | Y             |
   | INSTAGRAM    | N          | Y                | N             |
   | FACEBOOK     | N          | Y                | Y             |
   | WHATSAPP     | Y          | Y                | Y             |
   | TWITTER      | Y          | Y                | N             |
   | GMAIL        | N          | Y                | Y             |
   | SYSTEMSHARE  | -          | -                |-              |
   

  
  

