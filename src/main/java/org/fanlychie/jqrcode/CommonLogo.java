package org.fanlychie.jqrcode;

import java.io.InputStream;

/**
 * 二维码常用LOGO
 * Created by fanlychie on 2017/3/9.
 */
public final class CommonLogo {

    /**
     * 支付宝 LOGO
     */
    public static final InputStream ALIPAY = CommonLogo.class.getResourceAsStream("/logo/alipay_48x48.png");

    /**
     * 微信 LOGO
     */
    public static final InputStream WECHAT = CommonLogo.class.getResourceAsStream("/logo/wechat_48x48.png");

    private CommonLogo() {

    }

}