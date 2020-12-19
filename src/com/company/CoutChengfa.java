package com.company;

/**
 * @author ：songdalin
 * @date ：2020-12-19 下午 02:41
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CoutChengfa {

    /**
     * 输出一个数的乘法表,用于linux脚本演示
     */

    /**
     * #!/bin/bash
     * echo "请输入一个数字"
     * read num
     * if [[ -z $num  ]]
     * then echo "not black"
     *      exit
     * fi
     *
     * i=1
     * while [[ i -le num  ]]
     * do
     *
     *     if [[ $(($num%i)) -eq 0 ]]
     *     then   other=$(($num/$i))
     *        echo "$i"" * ""$other"" = ""$num"
     *     fi
     *     i=$(($i+1))
     * done
     *
     *
     * @param args
     */
    public static void main(String[] args){
        int num = 10;
        int i = 1;
        while (i <= num ) {
            if (num % i == 0) {
                int other = num / i;
                System.out.println(i + " * " + other + " = " + num);
            }
            i++;
        }
    }

}
