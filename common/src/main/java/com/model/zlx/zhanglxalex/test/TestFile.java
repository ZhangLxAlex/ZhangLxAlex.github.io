package com.model.zlx.zhanglxalex.test;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @ClassName TestMk
 * @Author zhang_lx
 * @Date 2020/8/25 下午3:39
 * @Version 1.0
 */
@Slf4j
public class TestFile {

    //读取问价夹~/wordcount/ *下所有文件

    //循环正则比对，格式[0-9]{1}

    //如果符合正则比对要求，计数器加一

    /**
     * 正则
     */
    private static final String PATTERN = "[0-9]\\{1\\}";

    /**
     * 文件夹
     */
    private static final String MKPATH = "/wordcount/";

    public static void main(String[] args) {
        try {
            File fileMk = new File(MKPATH);
            String[] fileList = fileMk.list();
            for (int i = 0; i < fileList.length; i++) {
                File file = new File(MKPATH+"/"+fileList[i]);
                //计数器
                int count = 0;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                StringBuffer sb = new StringBuffer();
                String line = null;
                while (null != (line = bufferedReader.readLine())) {
                    sb.append(line);
                }
                bufferedReader.close();

                for (int j = 0; j < sb.length(); j++) {
                    char c = sb.charAt(i);
                    //正则比对，符合计数器+1
                    boolean flag = Pattern.matches(PATTERN, c + "");
                    if (flag) {
                        count++;
                    }
                }
            }
        } catch (IOException e){
            log.error(e.getMessage());
        }

    }

}
