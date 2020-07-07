package com.model.zlx.zhanglxalex.javatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JavaTests {

    /**
     * 合并有序两数组测试
     */
    @Test
    public void javaTest() {
        int arr1[] = {1, 4, 5, 7, 10, 11, 15};
        int arr2[] = {2, 3, 6, 8, 9, 13, 14, 17};
        merge(arr1, arr2);
    }

    /**
     * 合并有序两数组
     *
     * @param arr1
     * @param arr2
     */
    public void merge(int[] arr1, int[] arr2) {
        //数组1长度
        int len1 = arr1.length;
        //数组2长度
        int len2 = arr2.length;
        //合并后数组长度
        int len = len1 + len2;
        //合并后的数组
        int arr[] = new int[len];
        int j = len1 - 1;
        int i = len2 - 1;
        len--;
        while (i >= 0 && j >= 0) {//从后向前比较
            if (arr2[i] > arr1[j]) {
                //将第二个数组的最后第i个元素放入arr中
                arr[len--] = arr2[i];
                //“指针”后移一位
                i--;
            } else if (arr2[i] <= arr1[j]) {
                //将第一个数组的最后第i个元素放入arr中
                arr[len--] = arr1[j];
                //“指针”后移一位
                j--;
            }
        }
        //将剩余的数组1或者数组2的元素全部追加到数组arr
        if (i > j) {
            while (i >= 0) {
                arr[len--] = arr2[i--];
            }
        } else {
            while (j >= 0) {
                arr[len--] = arr1[j--];
            }
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

}
