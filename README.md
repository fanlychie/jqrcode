# jqrcode

基于 Zxing 开发的二维码图片工具类

# 样例

**示例 1**
```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
		.toFile("C:/Users/Administrator/Desktop/qrcode_simple.png");
```

**效果图**

![qrcode_simple](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_simple.png)

**示例 2**

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
		.logo(Overlay.alipayLogo())
		.toFile("C:/Users/Administrator/Desktop/qrcode_alipay_logo.png");
```

**效果图**

![qrcode_alipay_logo](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_alipay_logo.png)

**示例 3**

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
		.logo(Overlay.wechatLogo())
		.toFile("C:/Users/Administrator/Desktop/qrcode_wechat.png");
```

**效果图**

![qrcode_wechat](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_wechat.png)

**示例 4**

```java
QrcodeGenerator.create("http://fanlychie.github.io/archives")
		.foregroundColor(Color.ORANGE)
		.logo(new File("C:/Users/Administrator/Desktop/ajjl.jpg"))
		.toFile("C:/Users/Administrator/Desktop/qrcode_customize.png");
```

**效果图**

![qrcode_customize](https://raw.githubusercontent.com/fanlychie/mdimg/master/qrcode_customize.png)