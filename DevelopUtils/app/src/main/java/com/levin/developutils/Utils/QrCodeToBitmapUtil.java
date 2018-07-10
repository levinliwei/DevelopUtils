package com.levin.developutils.Utils;

import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Hashtable;

/**
 * @auther levin
 * @Summary QrCodeToBitmapUtil  二维码 url转换工具类
 * @email levin.li@teamar.cn
 * @data 2018/7/3
 * @org Aurora Team
 */
public class QrCodeToBitmapUtil {

    /**
     * 将url 链接转换成二维码
     *
     * @param str    二维码的内容
     * @param width  二维码宽度
     * @param height 二维码高度
     * @return
     */
    public static Bitmap encodeAsBitmap(String str, int width, int height) {
        Bitmap bitmap = null;
        BitMatrix result = null;
        //生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 2);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            result = multiFormatWriter.encode(str, BarcodeFormat.QR_CODE, width, height, hints);
            // 使用 ZXing Android Embedded 要写的代码
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(result);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) { // ?
            return null;
        }
        return bitmap;
    }
}
