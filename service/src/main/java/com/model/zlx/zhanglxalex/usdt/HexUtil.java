//package com.model.zlx.zhanglxalex.usdt;
//
//import org.spongycastle.util.encoders.Hex;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//
///**
// * @ClassName HexUtil
// * @Author zhang_lx
// * @Date 2023/6/18 下午3:37
// * @Version 1.0
// */
//public class HexUtil {
//
//    /**
//     * double 转 16进制
//     */
//    public static String doubleToHex(Object value, int decimal) {
//        BigInteger temp = doubleToBigInteger(value, decimal);
//        return "0x" + temp.toString(16);
//    }
//
//    /**
//     * double 转 bigInteger
//     */
//    public static BigInteger doubleToBigInteger(Object value, int decimal) {
//        BigDecimal bd1 = null;
//        if (value instanceof Double) {
//            bd1 = new BigDecimal(Double.toString((double) value));
//        } else if (value instanceof BigDecimal) {
//            bd1 = (BigDecimal) value;
//        }
//        BigDecimal bd2 = new BigDecimal(Double.toString(Math.pow(10, decimal)));
//        return bd1.multiply(bd2).toBigInteger();
//    }
//
//    /**
//     * double 转 16进制
//     */
//    public static String intToHex(int x) {
//        return Integer.toHexString(x);
//    }
//
//    /**
//     * hex 转 byteArray
//     */
//    public static byte[] StringHexToByteArray(String x) throws Exception {
//        if (x.startsWith("0x")) {
//            x = x.substring(2);
//        }
//        if (x.length() % 2 != 0) {
//            x = "0" + x;
//        }
//        return Hex.decode(x);
//    }
//
//    public static String removeOx(String x) {
//        if (x.startsWith("0x")) {
//            x = x.substring(2);
//        }
//        return x;
//    }
//
//}
