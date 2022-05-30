package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 11:31 下午
 **/
public class InsertSort {

    public static void sort(int[] data){

        for (int i = 0; i < data.length; i++) {
            for (int j = i; j >=0 ; j--) {
                if (data[i]<data[j]){
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

    }

    public static void sort1(int[] data){
       int temp = 0;
        for (int i = 1; i < data.length; i++) {
            for (int j =i-1; j >= 0; j--) {
                if (data[i]<data[j]){
                    temp = data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }
    }

}
