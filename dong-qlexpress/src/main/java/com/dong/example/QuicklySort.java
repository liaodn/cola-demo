package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/6 6:23 下午
 **/
public class QuicklySort {
    public static void sort(int[] data,int start ,int end){
        //递归退出条件
        if(start>=end){
            return;
        }
        int left=start;
        int right=end;
        int piovt=data[start];
        while (left<right){
            while (left<right&& data[right]>=piovt){
                right--;
            }
            data[left] = data[right];
            while (left<right&&data[left]<=piovt){
                left++;
            }
            data[right]=data[left];
        }
        data[left]=piovt;
        sort(data,start,left-1);
        sort(data,left+1,end);
    }



    public static void sort1(int[] data,int start ,int end){

        if (end<=start){
            return;
        }

        int left=start;
        int right=end;
        int piovt = data[left];
        while (left<right){
            while (left<right&&data[right]>=piovt){
                right--;
            }
            data[left]=data[right];
            while (left<right&&data[left]<=piovt){
                left++;
            }
            data[right]=data[left];
        }
        data[left]=piovt;
        sort1(data,start,left-1);
        sort1(data,left+1,end);

    }
}
