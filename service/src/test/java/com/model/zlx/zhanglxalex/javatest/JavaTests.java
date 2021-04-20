package com.model.zlx.zhanglxalex.javatest;

import lombok.Data;
import org.assertj.core.internal.cglib.asm.$Opcodes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
        //merge(arr1, arr2);
        //find(arr1, arr2);
        System.out.println(maxLength(arr1));
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

    //        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    print123.print1();
//                }
//            }
//        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    print123.print2();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    print123.print3();
//                }
//            }
//        }).start();


    public void find(int[] arr1, int[] arr2){

        Set set = new HashSet();
        for(int i = 0; i < arr1.length-1; i++){
            if(0 == arr1[i]%2){
                set.add(arr1[i]);
            }
        }
        for(int i = 0; i < arr2.length-1; i++){
            if(0 == arr2[i]%2){
                set.add(arr2[i]);
            }
        }

        Object[] resArr = set.toArray();


        for (int i = resArr.length-1; i > 0; i--) {
            System.out.println(resArr[i]);
        }

        Arrays.sort(resArr);
        //Arrays.parallelSort(resArr);

        for (int i = resArr.length-1; i > 0; i--) {
            System.out.println(resArr[i]);
        }







    }

    public int maxLength (int[] arr) {
        // write code here

        if(0 == arr.length){
            return 0;
        }

        int res = 0;
        int maxLen = 0;
        Set set = new HashSet();

        for(int i = 0; i < arr.length-1; i++){
            if(!set.contains(arr[i])){
                res++;
                set.add(arr[i]);
            } else {
                maxLen = res;
                res = 0;
                set.clear();
                set.add(arr[i]);
            }

        }

        return maxLen;

    }


    @Test
    public void javaTest1() {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        int arr2[] = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        //getM(arr2, 7);
        //{3,4}

        getN();

    }


    public void getM(int[] arr, int target) {

        int sum = 0;

        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            sum += arr[i];

            temp = sum;

            for (int j = i + 1; j < arr.length - j; j++) {
                temp += arr[j];
                if (temp > target) {
                    sum = 0;
                    break;
                }
                if (temp == target) {
                    //这里我输出的是数组索引值
                    System.out.println(i + "--" + j);
                    return;

                }

            }

        }

    }
    //create index index1  on user (name, grade, age)
    //create index index2  on user age
    //age=20 and name=100
    //grade= and name


    public void getN() {

        int a = 100;
        int b = 90;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a+"--"+b);

    }








}

//@Data
//class Node {
//
//    private Integer value;
//    private Node next;
//
//    public static void main(String[] args) {
//
//        //4>5>6
//        Node node1 = new Node();
//
//        //4>6>7>9
//        Node node2 = new Node();
//
//        //结果5>1>3>5
//        Node node3 = add(node1, node2);
//    }
//
//    public static Node add(Node node1, Node node2) {
//        //TODO node3=node1+node2;
//        //反转
//        node1 = reNode(node1);
//        node2 = reNode(node2);
//
//        Node c1 = node1;
//        Node c2 = node2;
//
//        //结果
//        Node node = null;
//
//        int n1 = 0;
//        int n2 = 0;
//        int n = 0;
//        int ca = 0;
//
//        Node pre = null;
//
//        while (null != c1 || null != c2) {
//
//            n1 = null != c1 ? c1.value : 0;
//            n2 = null != c2 ? c2.value : 0;
//
//            n = n1 + n2 + ca;
//
//            pre = node;
//
//            node = new Node(Integer.valueOf(n % 10), null);
//
//            node.next = pre;
//            ca = n / 10;
//
//            c1 = null != c1 ? c1.next : null;
//            c2 = null != c2 ? c2.next : null;
//
//        }
//
//        //考虑头节点进位问题
//        if (1 == ca) {
//
//            pre = node;
//            node = new Node(Integer.valueOf(1), null);
//            node.next = pre;
//
//        }
//
//        //还原
//        node1 = reNode(node1);
//        node2 = reNode(node2);
//
//        return node;
//    }
//
//    /**
//     * 反转
//     *
//     * @param head
//     * @return
//     */
//    public static Node reNode(Node head){
//        Node pre = null;
//        Node next = null;
//
//        while(null != head){
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = head.next;
//        }
//
//        return null;
//    }
//}
