//package com.model.zlx.zhanglxalex.usdt;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.ethereum.core.Transaction;
//import org.spongycastle.util.encoders.Hex;
//import org.springframework.stereotype.Component;
//import org.web3j.abi.FunctionEncoder;
//import org.web3j.abi.TypeReference;
//import org.web3j.abi.datatypes.Address;
//import org.web3j.abi.datatypes.Function;
//import org.web3j.abi.datatypes.Type;
//import org.web3j.abi.datatypes.generated.Uint256;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName EthSign
// * @Author zhang_lx
// * @Date 2023/6/18 下午3:36
// * @Version 1.0
// */
//@Slf4j
//@Component
//public class EthSign {
//
//
//    public String sign(JSONObject json, String privateKey) throws Exception {
//        org.ethereum.crypto.ECKey ecKey = org.ethereum.crypto.ECKey.fromPrivate(new BigInteger(privateKey));
//
//        String from = json.getString("from");
//        String to = json.getString("to");
//        BigDecimal amount = json.getBigDecimal("value");
//        String gasLimit = json.getBigInteger("gasLimit").toString(16);
//        Double gasPriceTmp = json.getDouble("gasPrice");
//        String nonce = HexUtil.intToHex(json.getInteger("nonce"));
//        Integer chainId = json.getInteger("chainId");
//        String contractAddress = json.getString("contractAddress");
//        Integer decimal = json.getInteger("decimal");            // ETH的精度 18
//        Integer tokenDecimal = json.getInteger("tokenDecimal");  // token的精度
//        String data = json.getString("data");
//        if (data == null) {
//            data = "0x";
//        }
//        String gasPrice = HexUtil.doubleToHex(gasPriceTmp, decimal);
//        String value = HexUtil.doubleToHex(amount, decimal);
//
//        Transaction tx = null;
//        // 如果合约地址不为空，表示代币转账
//        if (!StringUtils.isEmpty(contractAddress)) {
//            List<Type> input = new ArrayList<>();
//            input.add(new Address(to));
//            input.add(new Uint256(HexUtil.doubleToBigInteger(amount, tokenDecimal)));
//            List<TypeReference<?>> output = new ArrayList<>();
//            Function function = new Function("transfer", input, output);
//            data = FunctionEncoder.encode(function);
//
//            tx = new org.ethereum.core.Transaction(
//                    HexUtil.StringHexToByteArray(nonce),
//                    HexUtil.StringHexToByteArray(gasPrice),
//                    HexUtil.StringHexToByteArray(gasLimit),
//                    //合约地址
//                    HexUtil.StringHexToByteArray(contractAddress),
//                    //转token ETH金额为0
//                    HexUtil.StringHexToByteArray("0"),
//                    HexUtil.StringHexToByteArray(data), chainId);
//        } else {
//            tx = new org.ethereum.core.Transaction(
//                    HexUtil.StringHexToByteArray(nonce),
//                    HexUtil.StringHexToByteArray(gasPrice),
//                    HexUtil.StringHexToByteArray(gasLimit),
//                    HexUtil.StringHexToByteArray(to),
//                    HexUtil.StringHexToByteArray(value),
//                    HexUtil.StringHexToByteArray(data), chainId);
//        }
//        tx.sign(ecKey);
//        return "0x" + Hex.toHexString(tx.getEncoded());
//    }
//
//
//}
