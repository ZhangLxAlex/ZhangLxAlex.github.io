//package com.model.zlx.zhanglxalex.javatest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class Javatest2 {
//
//    //两个有序单链表合并
//    public static void main(String[] args) {
//
//    }
//
//    public void function(ListNode l1, ListNode l2) {
//
//
//
//        ListNode res = new ListNode();
//        //flag
//        ListNode flag = res;
//
//
//        while (null != l1 && null != l2) {
//
//            if(l1.getVal() <= l2.getVal()){
//
//                res.next = l1;
//
//                //指针后移一位
//                l1 = l1.next;
//
//            } else {
//
//                res.next = l2;
//
//                l2 = l2.next;
//
//            }
//
//           flag = flag.next;
//        }
//
//    }
//
//}
