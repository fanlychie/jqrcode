package org.fanlychie.qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * 二维码图片生成器
 * Created by fanlychie on 2017/2/16.
 */
public final class QrcodeGenerator {

    /**
     * 二维码图片配置项
     */
    private static Map<EncodeHintType, Object> configuration;

    /**
     * 创建二维码图片
     *
     * @param content 二维码图片内容
     * @return 返回二维码对象
     */
    public static Qrcode createQrcode(String content) {
        return new Qrcode(content).setConfiguration(configuration);
    }

    // 私有化
    private QrcodeGenerator() {

    }

    static {
        configuration = new HashMap<>();
        configuration.put(EncodeHintType.MARGIN, 1);
        configuration.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        configuration.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    }

}