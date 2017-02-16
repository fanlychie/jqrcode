package org.fanlychie.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.fanlychie.qrcode.exception.RuntimeCastException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 二维码
 * Created by fanlychie on 2017/2/16.
 */
public class Qrcode {

    /**
     * 二维码图片尺寸大小
     */
    private int size = 200;

    /**
     * 二维码图片内容
     */
    private String content;

    /**
     * 二维码图片前景色
     */
    private Color foregroundColor = Color.BLACK;

    /**
     * 二维码图片背景色
     */
    private Color backgroundColor = Color.WHITE;

    /**
     * 二维码图片配置项
     */
    private Map<EncodeHintType, Object> configuration;

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
    public void output(String pathname) {
        output(new File(pathname));
    }

    /**
     * 输出二维码图片
     *
     * @param file 目标文件
     */
    public void output(File file) {
        if (file == null || content == null) {
            throw new NullPointerException();
        }
        BitMatrix matrix = null;
        try {
            matrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, size, size, configuration);
        } catch (WriterException e) {
            throw new RuntimeCastException(e);
        }
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, size, size);
        graphics.setColor(foregroundColor);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        String fileName = file.getName();
        String fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
        try {
            ImageIO.write(image, fileType, file);
        } catch (IOException e) {
            throw new RuntimeCastException(e);
        }
    }

    /**
     * 设置二维码图片尺寸大小
     *
     * @param size 二维码图片尺寸大小
     * @return 返回当前对象
     */
    public Qrcode setSize(int size) {
        this.size = size;
        return this;
    }

    /**
     * 设置二维码图片前景色
     *
     * @param foregroundColor 二维码图片前景色
     * @return 返回当前对象
     */
    public Qrcode setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        return this;
    }

    /**
     * 设置二维码图片背景色
     *
     * @param backgroundColor 二维码图片背景色
     * @return 返回当前对象
     */
    public Qrcode setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * 设置二维码图片配置项
     *
     * @param configuration 二维码图片配置项
     * @return 返回当前对象
     */
    public Qrcode setConfiguration(Map<EncodeHintType, Object> configuration) {
        this.configuration = configuration;
        return this;
    }

}