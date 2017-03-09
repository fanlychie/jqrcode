package org.fanlychie.jqrcode;

import com.google.zxing.common.BitMatrix;
import org.fanlychie.jqrcode.exception.QrcodeCastException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 图片输出工具
 * Created by fanlychie on 2017/3/9.
 */
public final class ImageWriter {

    /**
     * 将图片写到文件
     *
     * @param image 图片
     * @param file  目标文件
     */
    public static void writeImageToFile(BufferedImage image, File file) {
        writeImageToFile(image, file, (File) null);
    }

    /**
     * 将图片写到输出流
     *
     * @param image  图片
     * @param format 格式, 如: 'png'
     * @param stream 输出流
     */
    public static void writeImageToStream(BufferedImage image, String format, OutputStream stream) {
        try {
            ImageIO.write(image, format, stream);
        } catch (IOException e) {
            throw new QrcodeCastException(e);
        }
    }

    /**
     * 将图片写到文件
     *
     * @param image    图片
     * @param destFile 目标文件
     * @param logoFile logo文件
     */
    public static void writeImageToFile(BufferedImage image, File destFile, File logoFile) {
        InputStream logoInputStream = null;
        if (logoFile != null) {
            try {
                logoInputStream = new FileInputStream(logoFile);
            } catch (FileNotFoundException e) {
                throw new QrcodeCastException(e);
            }
        }
        writeImageToFile(image, destFile, logoInputStream);
    }

    /**
     * 将图片写到文件
     *
     * @param image           图片
     * @param destFile        目标文件
     * @param logoInputStream logo文件流
     */
    public static void writeImageToFile(BufferedImage image, File destFile, InputStream logoInputStream) {
        try {
            String filename = destFile.getName();
            if (logoInputStream != null) {
                BufferedImage logo = ImageIO.read(logoInputStream);
                int x = (image.getWidth() - logo.getWidth()) / 2;
                int y = (image.getHeight() - logo.getHeight()) / 2;
                Graphics2D graphics = (Graphics2D) image.getGraphics();
                graphics.drawImage(logo, x, y, null);
                graphics.setStroke(new BasicStroke(5));
                graphics.setColor(Color.WHITE);
                graphics.drawRect(x, y, logo.getWidth(), logo.getHeight());
            }
            ImageIO.write(image, filename.substring(filename.lastIndexOf('.') + 1), destFile);
        } catch (IOException e) {
            throw new QrcodeCastException(e);
        }
    }

    static BufferedImage toBufferedImage(BitMatrix matrix, Color foregroundColor, Color backgroundColor) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(foregroundColor);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        return image;
    }

    private ImageWriter() {

    }

}