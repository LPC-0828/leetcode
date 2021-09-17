package com.leetcode.demo.ycq.array;

import org.junit.Test;

import java.util.Arrays;

/*
*977. 有序数组的平方
*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序
* */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int[] nums2 = new int[100000];
        int[] resultArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums2[Math.abs(nums[i])] < 1){
                nums2[Math.abs(nums[i])] = 1;
            } else {
                nums2[Math.abs(nums[i])]++;
            }
        }

        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == 1){
                resultArray[index++] = (int) Math.pow(i, 2);
            } else if (nums2[i] > 1){
                for (int j = 0; j < nums2[i]; j++) {
                    resultArray[index++] = (int) Math.pow(i, 2);
                }
            }
        }

        return resultArray;
    }


    public int[] sortedSquares2(int[] nums) {
        int[] resultArray = new int[nums.length];
        // 双指针
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right){
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                resultArray[index--] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                resultArray[index--] = (int) Math.pow(nums[right], 2);
                right--;
            }
        }

        return resultArray;
    }

    public int[] sortedSquares3(int[] nums) {
        int[] resultArray = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right){
            // 非负数不需要进行比较
            if (nums[left] >= 0){
                resultArray[index--] = (int) Math.pow(nums[right--], 2);
                continue;
            }
            if (Math.abs(nums[left]) > Math.abs(nums[right])){
                resultArray[index--] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                resultArray[index--] = (int) Math.pow(nums[right], 2);
                right--;
            }
        }

        return resultArray;
    }

    @Test
    public void test(){
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares3(nums)));
    }
}
