# jqrcode

基于 Zxing 开发的二维码图片工具类

# 样例

**示例1**
```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .toFile("C:/Users/Administrator/Desktop/qrcode_simple.png");
```

**效果图**

![qrcode_simple](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_simple.png)

**示例2**

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .logo(Overlay.alipayLogo())
                .toFile("C:/Users/Administrator/Desktop/qrcode_alipay_logo.png");
```

**效果图**

![qrcode_alipay_logo](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_alipay_logo.png)

**示例3**

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
                .logo(Overlay.wechatLogo())
                .toFile("C:/Users/Administrator/Desktop/qrcode_wechat.png");
```

**效果图**

![qrcode_wechat](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_wechat.png)