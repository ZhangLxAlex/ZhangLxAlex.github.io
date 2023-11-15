package com.model.zlx.zhanglxalex.cputest;

import com.model.zlx.zhanglxalex.entity.TMyUserEntity;
import com.model.zlx.zhanglxalex.mapper.TMyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CpuTests {

    @Test
    public void testCpu() {
        //dataMap设置为空，则死循环
        Map<String, Date> dataMap = new HashMap<>();

        Map<String, Object> paramMap = new HashMap<>();
        //初始化死值
        paramMap.put("1", new Date());
        paramMap.put("2", new Date());

        System.out.println(paramMap.toString());

        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            for (String dataMapItem : dataMap.keySet()) {
                if (iterator.next().equals(dataMapItem)) {
                    System.out.println("paramMap remove-->" + dataMapItem);
                    iterator.remove();
                }
            }
        }
    }

    @Test
    public void testCpuTure() {
        //dataMap设置为空，则死循环
        Map<String, Date> dataMap = new HashMap<>();

        Map<String, Object> paramMap = new HashMap<>();
        //初始化死值
        paramMap.put("1", new Date());
        paramMap.put("2", new Date());

        System.out.println(paramMap.toString());

        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            String keyName = iterator.next();
            for (String dataMapItem : dataMap.keySet()) {
                if (keyName.equals(dataMapItem)) {
                    System.out.println("paramMap remove-->" + dataMapItem);
                    iterator.remove();
                }
            }
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1.0;
        long nn = n;
        if (nn < 0)
        {
            nn = -nn;
            x = 1 / x;
        }
        while (nn > 0)
        {
            if (nn % 2 == 1)
                res *= x;
            x *= x;
            nn /= 2;
        }
        return res;
    }

    @Test
    public void testPow() {
//        myPow(2,3);
        longestPalindrome("aaaa");
//        corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    public int[] twoSum(int[] numbers, int target) {

        //key 值，value i
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-map.get(numbers[i]))){
                return new int[]{map.get(numbers[i]),i};
            } else {
                map.put(numbers[i],i);
            }
        }

        return null;

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }

        int length = s.length();
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        int maxLength = 1;

        boolean[][] dp = new boolean[length][length];    // dp[i][j]表示 从i到j的子串 是否 满足“回文特性”
        for (int rightIndex = 1; rightIndex < length; rightIndex++) {
            for (int leftIndex = 0; leftIndex < rightIndex; leftIndex++) {
                        /*
                            若 当前子串：
                                1、第一个字符 和 最后一个字符 相等
                                2、子串长度<3 或 减去首尾俩字符的子串也满足回文特性
                        */
                if (s.charAt(leftIndex) == s.charAt(rightIndex) && (rightIndex - leftIndex <= 2 || dp[leftIndex + 1][rightIndex - 1])) {    // 利用 dp存储的“之前结果”，进行优化
                    dp[leftIndex][rightIndex] = true;
                    if (rightIndex - leftIndex + 1 > maxLength) {
                        maxLength = rightIndex - leftIndex + 1;
                        maxStartIndex = leftIndex;
                        maxEndIndex = rightIndex;
                    }
                }

            }
        }

        return s.substring(maxStartIndex, maxEndIndex + 1);

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                counters[booking[1]] -= booking[2];
            }
        }
        System.out.println(counters.toString());
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }
        return counters;
    }


}
