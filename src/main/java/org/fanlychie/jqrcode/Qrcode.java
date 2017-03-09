package org.fanlychie.jqrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.fanlychie.jqrcode.exception.QrcodeCastException;
import org.fanlychie.jqrcode.exception.WriteQrcodeException;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

/**
 * 二维码
 * Created by fanlychie on 2017/2/16.
 */
public class Qrcode {

    /**
     * 图片尺寸大小
     */
    private int size;

    /**
     * 图片内容
     */
    private String content;

    /**
     * 图片前景色
     */
    private Color foregroundColor;

    /**
     * 图片背景色
     */
    private Color backgroundColor;

    /**
     * 二维码LOGO
     */
    private InputStream logoInputStream;

    /**
     * 可选配置项
     */
    private Map<EncodeHintType, Object> config;

    /**
     * 构造器
     *
     * @param content 二维码内容
     */
    public Qrcode(String content) {
        this.content = content;
    }

    /**
     * 输出二维码图片
     *
     * @param pathname 目标文件全路径
     */
    public void toFile(String pathname) {
        toFile(new File(pathname));
    }

    /**
     * 输出二维码图片
     *
     * @param file 目标文件
     */
    public void toFile(File file) {
        if (file == null) {
            throw new WriteQrcodeException("the file can not be null");
        }
        if (content == null) {
            throw new WriteQrcodeException("qrcode image content can not be null");
        }
        BitMatrix matrix = null;
        try {
            matrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, size, size, config);
        } catch (WriterException e) {
            throw new QrcodeCastException(e);
        }
        ImageWriter.writeImageToFile(ImageWriter.toBufferedImage(matrix, foregroundColor, backgroundColor), file, logoInputStream);
    }

    /**
     * 设置二维码图片 logo
     *
     * @param logo 二维码图片 logo
     * @return 返回当前对象
     */
    public Qrcode logo(File logo) {
        try {
            this.logoInputStream = new FileInputStream(logo);
        } catch (FileNotFoundException e) {
            throw new QrcodeCastException(e);
        }
        return this;
    }

    /**
     * 设置二维码图片 logo
     *
     * @param logoInputStream 二维码图片logo输入流
     * @return 返回当前对象
     */
    public Qrcode logo(InputStream logoInputStream) {
        this.logoInputStream = logoInputStream;
        return this;
    }

    /**
     * 设置二维码图片尺寸大小
     *
     * @param size 二维码图片尺寸大小
     * @return 返回当前对象
     */
    public Qrcode size(int size) {
        this.size = size;
        return this;
    }

    /**
     * 设置二维码图片配置项
     *
     * @param config 二维码图片配置项
     * @return 返回当前对象
     */
    public Qrcode config(Map<EncodeHintType, Object> config) {
        this.config = config;
        return this;
    }

    /**
     * 设置二维码图片前景色
     *
     * @param foregroundColor 二维码图片前景色
     * @return 返回当前对象
     */
    public Qrcode foregroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        return this;
    }

    /**
     * 设置二维码图片背景色
     *
     * @param backgroundColor 二维码图片背景色
     * @return 返回当前对象
     */
    public Qrcode backgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

}