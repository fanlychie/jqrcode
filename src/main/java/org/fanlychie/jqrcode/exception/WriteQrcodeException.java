package org.fanlychie.jqrcode.exception;

/**
 * 二维码输出异常
 * Created by fanlychie on 2017/3/9.
 */
public class WriteQrcodeException extends RuntimeException {

    public WriteQrcodeException(String message) {
        super(message);
    }

}