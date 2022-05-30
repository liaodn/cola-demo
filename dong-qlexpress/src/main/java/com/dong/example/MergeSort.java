package com.dong.example;

/**
 * @email DONGNIAN.LIAO@opple.com
 * @author: 廖冬年
 * @date 2022/5/7 9:44 上午
 **/
public class MergeSort {

    public static void sort(int[] data,int start, int end,int[] temp){
        if (data==null||data.length==1){
            return ;
        }
        if (start<end) {
            int mid = (end - start) / 2+start;
            sort(data, start, mid,temp );
            sort(data, mid+1, end, temp);
            merge(data,start,mid,end,temp);
        }
    }

    private static void merge(int[] data, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid+1;
        int index=0;
        while (i<=mid&&j<=end){
            if(data[i]>data[j]){
                temp[index] = data[j];
                j++;

            }else {
                temp[index] = data[i];
                i++;
            }
            index++;
        }
        while (i<=mid){
            temp[index]=data[i];
            i++;
            index++;
        }
        while (j<=end){
            temp[index]=data[j];
            j++;
            index++;
        }
        for (int k = start; k <= end; k++) {
            data[k] = temp[k-start];
        }
    }

    public static void sort1(int[] data,int start ,int end ,int[] temp){

        if (start>=end)return;

        int mid = (start+end)/2;

        sort1(data,start,mid,temp);
        sort1(data,mid+1,end,temp);
        merge(data,start,mid,end,temp);
    }

    private static void merge1(int[] data, int start, int mid, int end, int[] temp) {
        int i=start;
        int j = end;
        int index=0;
        while (i<=mid&&j<=end){
            if (data[i]<data[j]){
                temp[index++] = data[i++];
            }else {
                temp[index++] = data[j++];
            }
        }
        while (i<=mid){
            temp[index++] = data[i++];
        }
        while (j<=end){
            temp[index++] = data[j++];
        }
        for (int k = start; k <= end; k++) {
            data[k] = temp[k-start];
        }

    }

}
