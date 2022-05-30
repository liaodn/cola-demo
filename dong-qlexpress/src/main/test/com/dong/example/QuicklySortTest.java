package com.dong.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 8:29 下午
 **/
public class QuicklySortTest {

    @Test
    public void testSort(){
        int[] arr = new int[]{1,3,2,5,4,8,9,7,7};
        int[] res = new int[]{1,2,3,4,5,7,7,8,9};
        QuicklySort.sort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(arr,res);
    }


    @Test
    public void testSelectSort(){
        int[] arr = new int[]{1,3,2,5,4,4,5,5,6,2};
        int[] res = new int[]{1,2,2,3,4,4,5,5,5,6};
        SelectSort.sort1(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(arr,res);
    }


    @Test
    public void testInsertSort(){
        int[] arr = new int[]{1,3,2,5,4,9,8,100};
        int[] res = new int[]{1,2,3,4,5,8,9,100};
        InsertSort.sort1(arr);
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(arr,res);
    }

    @Test
    public void testMergeSort(){
        int[] arr = new int[]{1,3,2,5,4,9,8,7,7};
        int[] res = new int[]{1,2,3,4,5,7,7,8,9};
        MergeSort.sort1(arr,0,arr.length-1,new int[arr.length]);
        System.out.println(Arrays.toString(arr));
        Assert.assertArrayEquals(arr,res);
    }


}
