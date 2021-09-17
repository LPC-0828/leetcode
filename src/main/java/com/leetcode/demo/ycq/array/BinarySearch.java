package com.leetcode.demo.ycq.array;

import org.junit.Test;

/* 704. 二分查找
* 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。

示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        // 定义两个指针
        int low = 0;
        int high = nums.length - 1;
        // 因为奇数除以2向下取整的问题, 必须low > high的时候才算把范围缩小到一个元素
        while (low <= high){
            // 找出中间值
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target){
                // 大了, 要改变high
                high = --mid;
            } else {
                // 小了, 要改变low
                low = ++mid;
            }
        }

        return -1;
    }

    @Test
    public void test(){
        int[] nums = {-1,0,3,4,9,12};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
