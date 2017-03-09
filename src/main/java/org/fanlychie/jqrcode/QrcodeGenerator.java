package org.fanlychie.jqrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码图片生成器
 * Created by fanlychie on 2017/2/16.
 */
public final class QrcodeGenerator {

    private static final int DEFAULT_SIZE = 200;

    private static final Map<EncodeHintType, Object> DEFAULT_HINT_TYPE_MAP = new HashMap<>();

    /**
     * 创建二维码图片
     *
     * @param content 二维码图片内容
     * @return 返回二维码对象
     */
    public static Qrcode create(String content) {
        return new Qrcode(content)
                .size(DEFAULT_SIZE)
                .foregroundColor(Color.BLACK)
                .backgroundColor(Color.WHITE)
                .config(DEFAULT_HINT_TYPE_MAP)
                ;
    }

    static {
        DEFAULT_HINT_TYPE_MAP.put(EncodeHintType.MARGIN, 1);
        DEFAULT_HINT_TYPE_MAP.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        DEFAULT_HINT_TYPE_MAP.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
    }

    // 私有化
    private QrcodeGenerator() {

    }

}