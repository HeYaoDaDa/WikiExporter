package exporter.utils;

import java.awt.*;

public class CommonUtils {
    public static String convertToHex(Color color) {
        // 获取RGB整数
        int rgb = color.getRGB();
        // 去掉alpha通道
        rgb &= 0x00ffffff;
        // 将RGB整数转换为十六进制字符串
        StringBuilder hexString = new StringBuilder(Integer.toHexString(rgb));
        // 确保十六进制字符串长度为6
        while (hexString.length() < 6) {
            hexString.insert(0, "0");
        }
        return hexString.toString();
    }
}
