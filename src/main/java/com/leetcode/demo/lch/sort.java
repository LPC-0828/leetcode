package com.leetcode.demo.lch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 排序算法
 */
public class sort {
    public static void main(String[] args) {
        //bubbleSortdesc(new int[] {1,5,9,8,7,6});
        //selectSort(new int[] {1,5,9,8,7,6});
        //insertionSort(new int[] {1,5,9,8,7,6});
        quickSort(new int[] {1,5,9,8,7,6},2,6);
        List a = new ArrayList<>();
        Iterator iterator = a.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
        }

    }
    public static void bubbleSort(int[] nums){
        for(int i=0 ;i <nums.length-1; i++){//从下标0开始
            for(int j=0 ;j <nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void bubbleSortdesc(int[] nums){
        for(int i=0 ;i <nums.length-1; i++){//从下标0开始
            for(int j=0 ;j <nums.length-i-1; j++){
                if(nums[j] < nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void selectSort(int[] nums){
        int minVal;
        int minIndex;
        for(int i=0 ; i<nums.length-1;i++){
            minVal = nums[i];
            minIndex = i;
            for (int j = i+1 ; j<nums.length;j++){
                if(nums[j] < minVal){
                    minVal = nums[j];
                    minIndex = j;
                }
            }
            if(minVal != nums[i] && minIndex !=i){
                nums[minIndex] = nums[i];
                nums[i] = minVal;
            }
        }
        System.out.println(nums);
    }

    public static void insertionSort(int[] data){
        for(int i=1;i<data.length;i++){
            for(int j=i;j>0;j--){
                if(data[j]<data[j-1]){
                    int tem = data[j];
                    data[j] = data[j-1];
                    data[j-1] = tem;
                }
            }
        }
        System.out.println(data);
    }

    public static void quickSort(int[] data,int star, int last){
        if(last  - star <= 0){
            return;
        }
        int en = star;
        for(int i=star +1;i<last;i++){
            if(data[i]<data[star]){
                int tem = data[++en];
                data[en] = data[i];
                data[i] = tem;
            }

        }
        int tre = data[en];
        data[en]= data[star];
        data[star]=tre;
        quickSort(data,star,en-1);
        quickSort(data,en+1,last);
        System.out.println(data);
    }


}
