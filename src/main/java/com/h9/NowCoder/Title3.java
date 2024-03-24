package com.h9.NowCoder;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * 3. 数组中重复的数字
 *
 *  在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 *  数组中某些数字是重复的，但不知道有几个数字是重复的。
 *  也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *  例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。
 *  存在不合法的输入的话输出-1
 *
 * 数据范围：0≤n≤10000
 *
 *
 */
public class Title3 {
    public static void main(String[] args) {
        int[] numbers= {2,3,1,0,20,5,3};
        System.out.println(duplicate(numbers));
    }




    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int duplicate(int[] numbers) {
            boolean b = Arrays.stream(numbers).allMatch(number->number==number);



        return -1;
    }
}
