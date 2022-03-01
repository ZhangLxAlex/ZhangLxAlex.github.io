package com.model.zlx.zhanglxalex.hashtest;

import com.model.zlx.zhanglxalex.util.HashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HashTests {

    @Test
    public void testHash() {
        String str = "123456";
        try {
            String resultMd5 = HashUtil.md5(str.getBytes());
            String resultSha1 = HashUtil.sha1Bytes(str.getBytes());
            String resultSha256 = HashUtil.sha256Bytes(str.getBytes());
            String ripemd160Bytes = HashUtil.ripemd160Bytes(str.getBytes());
            System.out.println(resultMd5);
            System.out.println(resultSha1);
            System.out.println(resultSha256);
            System.out.println(ripemd160Bytes);
        } catch (Exception e){
            //处理e
            e.printStackTrace();
        }

        System.out.println("++++++++++++++++++++++");

        byte[] arrStr = HashUtil.hexStr2HexBytes(str);
        try {
            String resultMd5 = HashUtil.md5(arrStr);
            String resultSha1 = HashUtil.sha1Bytes(arrStr);
            String resultSha256 = HashUtil.sha256Bytes(arrStr);
            String ripemd160Bytes = HashUtil.ripemd160Bytes(arrStr);

            System.out.println(resultMd5);
            System.out.println(resultSha1);
            System.out.println(resultSha256);
            System.out.println(ripemd160Bytes);

        } catch (Exception e){
            //处理e
            e.printStackTrace();
        }
    }

}
