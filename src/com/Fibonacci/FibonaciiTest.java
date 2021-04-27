package com.Fibonacci;

/**
 * @author ：songdalin
 * @date ：2021-04-27 上午 09:24
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class FibonaciiTest {

    /**
     * 菲波那切数列
     *
     * 0 1 1 2 3    每个数是前两个数之和
     */

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            System.out.print(find(i) + "  ");
        }

    }

    /**
     * 递归调用
     * @param index
     * @return
     */
    public static int find (int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;

        if (index > 1) {
            return find(index -1) + find(index - 2);
        }
        return -1;
    }
}
