package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/8 11:14 下午
 **/
public class BSearch {
    public static int search(int[] data,int start,int end,int value){
        if (start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if (data[mid]==value){
            return mid;
        }else if (data[mid]>value){
            return   search(data,start,(start+end)/2-1,value);
        }else {
            return   search(data,(start+end)/2+1,end,value);
        }

    }

    public static void main(String[] args) {
        int[]  a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(search(a,0,a.length-1,8));
    }
}
