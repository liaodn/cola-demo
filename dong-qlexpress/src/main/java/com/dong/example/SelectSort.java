package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 10:48 下午
 **/
public class SelectSort {
    public static void sort(int[] data){

        if (data==null || data.length==1){
            return ;
        }

        //swap 中间值
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int index = i;
            for (int j = i+1; j < data.length; j++) {
                if (min>data[j]){
                    min=data[j];
                    index=j;
                }
            }
            data[index]=data[i];
            data[i] = min;
        }

    }

    public static void sort1(int[] data){
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int index=i;
            for (int j = i+1; j < data.length; j++) {
                if (min>data[j]){
                    min = data[j];
                    index=j;
                }
            }
            data[index]=data[i];
            data[i]= min;

        }
    }
}
