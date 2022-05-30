package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 5:52 下午
 **/
public class BubbleSort {

    public static int[] sort(int[] data){
        if (data==null||data.length==1){
            return data;
        }
        int temp;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-i-1; j++) {
                if (data[j]>data[j+1]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        return data;
    }

    public static void sort1(int[] data){
        int temp=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length-1; j++) {
                if (data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                    data[j+1]=temp;
                }
            }
        }
    }
}
