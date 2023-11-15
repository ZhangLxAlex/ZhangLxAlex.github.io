//package com.model.zlx.zhanglxalex.util;
//
//import org.bouncycastle.crypto.digests.RIPEMD160Digest;
//
//import java.security.MessageDigest;
//
///**
// * @ClassName HashUtil
// * @Author zhang_lx
// * @Date 2022/3/2 上午12:54
// * @Version 1.0
// */
//public class HashUtil {
//
//    /**
//     * md5消息摘要
//     *
//     * @param data
//     * @return
//     * @throws Exception
//     */
//    public static String md5(byte[] data) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] digest = md.digest(data);
//        return bytes2HexStr(digest);
//    }
//
//    /**
//     * 字节数组转换16进制
//     *
//     * @param data
//     * @return
//     */
//    public static String bytes2HexStr(byte[] data) {
//        StringBuffer stringBuffer = new StringBuffer();
//        for (byte b : data) {
//            stringBuffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
//        }
//
//        return stringBuffer.toString();
//    }
//
//    /**
//     * SHA-1消息摘要方法
//     *
//     * @param data
//     * @return
//     */
//    public static String sha1Bytes(byte[] data) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("SHA");
//        byte[] digest = md.digest(data);
//        return bytes2HexStr(digest);
//    }
//
//    /**
//     * SHA-256消息摘要方法
//     *
//     * @param data
//     * @return
//     */
//    public static String sha256Bytes(byte[] data) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        byte[] digest = md.digest(data);
//        return bytes2HexStr(digest);
//    }
//
//    /**
//     * SHA-512消息摘要方法
//     *
//     * @param data
//     * @return
//     */
//    public static String sha512Bytes(byte[] data) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
//        byte[] digest = md.digest(data);
//        return bytes2HexStr(digest);
//    }
//
//    /**
//     * ripemd160 hash消息摘要方法
//     *
//     * @param data
//     * @return
//     */
//    public static String ripemd160Bytes(byte[] data) throws Exception {
//        RIPEMD160Digest ripemd160Digest = new RIPEMD160Digest();
//        ripemd160Digest.update(data, 0, data.length);
//        byte[] digest = new byte[ripemd160Digest.getDigestSize()];
//        ripemd160Digest.doFinal(digest, 0);
//        return bytes2HexStr(digest);
//    }
//
//    /**
//     * 将16进制表达式转成字节数组 按照每两位一个字节
//     *
//     * @param hexStr
//     * @return
//     */
//    public static byte[] hexStr2HexBytes(String hexStr) {
//        if (null == hexStr || 0 == hexStr.length()) {
//            return null;
//        }
//        hexStr = (1 == hexStr.length()) ? "0" + hexStr : hexStr;
//        byte[] arr = new byte[hexStr.length() / 2];
//        byte[] temp = hexStr.getBytes();
//        for (int i = 0; i < temp.length / 2; i++) {
//            arr[i] = unitBytes(temp[i * 2], temp[i * 2 + 1]);
//        }
//        return arr;
//    }
//
//    public static byte unitBytes(byte src0, byte src1) {
//        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
//        _b0 = (byte) (_b0 << 4);
//        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
//        byte ret = (byte) (_b0 ^ _b1);
//        return ret;
//    }
//
//}
