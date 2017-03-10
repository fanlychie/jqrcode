package org.fanlychie.jqrcode;

import java.io.InputStream;

/**
 * 常用图标
 * Created by fanlychie on 2017/3/9.
 */
public final class Overlay {

    private static final String ALIPAY_LOGO_PATH = "/logo/alipay_48x48.png";

    private static final String WECHAT_LOGO_PATH = "/logo/wechat_48x48.png";

    /**
     * 支付宝 logo
     */
    public static InputStream alipayLogo() {
        return Overlay.class.getResourceAsStream(ALIPAY_LOGO_PATH);
    }

    /**
     * 微信 logo
     */
    public static InputStream wechatLogo() {
        return Overlay.class.getResourceAsStream(WECHAT_LOGO_PATH);
    }

    private Overlay() {

    }

}