package com.BinarySearch;

import com.company.Main;

import java.util.Arrays;

/**
 * @author ：songdalin
 * @date ：2021-04-27 上午 09:37
 * @description：二分查找
 * @modified By：
 * @version: 1.0
 */
public class BinarySearch {

    public static void main(String[] args){
        //           0  1  2  3    4   5  6   7   8   9
        int[] arr = {1, 2, 9, 12, 17, 34, 43, 67, 80, 99};
        int start = 0;
        int end = arr.length;
        int x = 99;
        //System.out.println(Arrays.binarySearch(arr, 80));
        System.out.println("元素位置： " + binarySearch(arr, start, end, x));
    }

    /**
     * 二分查找递归
     *      ********有序队列***********
     *
     * @param arr      递归数组
     * @param start    开始查找位置
     * @param end      结束查找位置
     * @param x        待查找数据
     * @return         返回查找数据所在位置，没有返回-1
     */
    public static int binarySearch(int[] arr, int start, int end, int x) {
        if (start > end) return -1;

        int tmp = (start + end) / 2;

        if (arr[tmp] == x)
            return tmp;
        //前半部分递归
        else if (arr[tmp] > x) {
            return binarySearch(arr, start, tmp - 1, x);
        }
        //后半部分递归
        else {
            return binarySearch(arr, tmp + 1, end, x);
        }

    }
}
