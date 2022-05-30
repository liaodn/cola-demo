package com.dong.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 5:57 下午
 **/
public class BubbleSortTest {

    public void setUp(){

    }


    @Test
    public void testNull(){
        int[] arr = null;
        arr=BubbleSort.sort(arr);
        Assert.assertNull(arr);
    }

    @Test
    public void testSort(){
        int[] arr = new int[]{1,3,2,5,4,7,0,9,8,9};
        BubbleSort.sort1(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals("成功",new int[]{0,1,2,3,4,5,7,8,9,9},arr);
    }
}
