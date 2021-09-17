package com.leetcode.demo.ycq.array;

import org.junit.Test;

/*
*
* 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
*
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
* 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
*
* */
public class RemoveElement {

    // 遍历两遍, 把相等的换到后面去
    public int removeElement1(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[i] + nums[j];
                        nums[j] = nums[i] - nums[j];
                        nums[i] = nums[i] - nums[j];
                        len++;
                        break;
                    }
                }
            } else {
                len++;
            }
        }

        return len;
    }

    // 双指针
    public int removeElement2(int[] nums, int val) {
        int left = 0;
        for (int right = nums.length - 1; left <= right; right--) {
            if (nums[left] != val){
                left++;
                right++;
                continue;
            }

            if (nums[left] == val && nums[right] != val){
                // 交换
                nums[left] = nums[left] + nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] = nums[left] - nums[right];
            }
        }

        return left;
    }

    // 官方双指针
    public int removeElement3(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }

        return left;
    }

    // 官方双指针优化
    public int removeElement4(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val){
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    @Test
    public void test(){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement4(nums, val);
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i == len - 1){
                System.out.println((nums[i]) + "]");
            } else {
                System.out.print((nums[i]) + ", ");
            }

        }
    }
}
