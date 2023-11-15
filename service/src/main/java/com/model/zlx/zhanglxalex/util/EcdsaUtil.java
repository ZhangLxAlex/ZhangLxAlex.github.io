//package com.model.zlx.zhanglxalex.util;
//
//import org.bouncycastle.crypto.params.ECDomainParameters;
//import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
//import org.bouncycastle.crypto.params.ParametersWithRandom;
//import org.bouncycastle.crypto.signers.ECDSASigner;
//import org.bouncycastle.jce.ECNamedCurveTable;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
//import org.bouncycastle.math.ec.ECPoint;
//
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.math.BigInteger;
//import java.security.SecureRandom;
//import java.security.Security;
//import java.util.LinkedList;
//
///**
// * @ClassName EcdsaUtil
// * @Author zhang_lx
// * @Date 2022/3/2 上午1:56
// * @Version 1.0
// */
//public class EcdsaUtil {
//
//    private static final String RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";
//    private static final String RANDOM_NUMBER_ALGORITHM_PROVIDER = "SUN";
//
//    /**
//     * 利用私钥生成公钥
//     *
//     * @param privateKey
//     * @return
//     */
//    public static byte[] generatePublicKey(byte[] privateKey){
//        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
//        ECPoint pointQ = spec.getG().multiply(new BigInteger(1,privateKey));
//
//        return pointQ.getEncoded(true);
//    }
//
//    /**
//     * 随机产生私钥
//     *
//     * @return
//     */
//    public static byte[] generatePrivateKey(){
//
//        SecureRandom secureRandom = new SecureRandom();
//        BigInteger privateKeyCheck = BigInteger.ZERO;
//        BigInteger maxKey = new BigInteger("00FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364140", 16);
//
//        //产生随机字节数组
//        byte[] privateKeyAttempt  = new byte[32];
//        secureRandom.nextBytes(privateKeyAttempt);
//        privateKeyCheck = new BigInteger(1,privateKeyAttempt);
//        while (privateKeyCheck.compareTo(BigInteger.ZERO)==0||privateKeyCheck.compareTo(maxKey)==1){
//            secureRandom.nextBytes(privateKeyAttempt);
//            privateKeyCheck = new BigInteger(1,privateKeyAttempt);
//        }
//
//
//        return privateKeyAttempt;
//    }
//
//    /**
//     * 椭圆曲线算法对消息签名,返回二维数组
//     *
//     * @param massage
//     * @param privateKey
//     * @return
//     */
//    public static byte[][] signTransaction(byte[] massage, byte[] privateKey) {
//
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//            ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
//
//            ECDSASigner ecdsaSigner = new ECDSASigner();
//            ECDomainParameters domain = new ECDomainParameters(spec.getCurve(), spec.getG(), spec.getN());
//            ECPrivateKeyParameters privateKeyParameters = new ECPrivateKeyParameters(
//                    new BigInteger(1, privateKey), domain);
//            //随机数签名参数
//            ParametersWithRandom params = new ParametersWithRandom(privateKeyParameters);
//            ecdsaSigner.init(true, params);
//
//            //生成签名
//            BigInteger[] sig = ecdsaSigner.generateSignature(massage);
//            LinkedList<byte[]> sigData = new LinkedList<>();
//            byte[] publicKey = generatePublicKey(privateKey);
//            //byte recoveryId = ;
//            for (BigInteger sigChunk : sig) {
//                sigData.add(sigChunk.toByteArray());
//            }
//            //sigData.add(new byte[]{recoveryId});
//            return sigData.toArray(new byte[][]{});
//
//        } catch (Exception e) {
//            StringWriter errors = new StringWriter();
//            e.printStackTrace(new PrintWriter(errors));
//            return new byte[0][0];
//        }
//    }
//
//    /**
//     * 根据私钥签名推算其对应的公钥
//     *
//     * @param sigR
//     * @param sigS
//     * @param sigV
//     * @param message
//     * @return
//     */
//    public static byte[] recoverPublicKey(byte[] sigR,byte[] sigS,byte[] sigV,byte[] message){
//        return null;
//    }
//
//
//
//}
