# jqrcode

基于 Zxing 开发的二维码图片工具类

# 示例

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .toFile("C:/Users/Administrator/Desktop/qrcode_simple.png");
```

![qrcode_simple](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_simple.png)

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .logo(Overlay.alipayLogo())
                .toFile("C:/Users/Administrator/Desktop/qrcode_alipay_logo.png");
```

![qrcode_alipay_logo](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_alipay_logo.png)

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .logo(Overlay.wechatLogo())
                .toFile("C:/Users/Administrator/Desktop/qrcode_wechat.png");
```

![qrcode_wechat](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_wechat.png)