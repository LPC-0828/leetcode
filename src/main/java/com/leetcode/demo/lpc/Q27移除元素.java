package com.leetcode.demo.lpc;

import org.junit.Test;

/**
 * <p>
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p/>
 *
 * @author Ray
 * @date: 2021.09.02 21:15
 */
public class Q27移除元素 {


    @Test
    public void 自己() {
        System.out.println(removeElement优化版(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
//        System.out.println(removeElement优化版(new int[]{4, 4, 0, 1, 0, 2}, 0));
//        System.out.println(removeElement优化版(new int[]{3, 2, 2, 3}, 3));
    }

    /**
     * 遍历两次
     * c是出现相同数字的次数
     * nums.length - c 就是移除之后的数组
     */
    public int removeElement(int[] nums, int val) {
        int c = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == val) {
                if (i == nums.length - 1) {
                    nums[i] = -1;
                    i++;
                } else {
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                        nums[j] = -1;
                    }
                }
                c++;
            } else {
                i++;
            }
        }
        return nums.length - c;
    }

    /**
     * 循环一次 将后面的元素填补到前面的位置
     */
    public int removeElement优化版(int[] nums, int val) {
        int a = 0, b = nums.length - 1;
        for (int i = 0; i <= b; ) {
            if (nums[i] == val) {
                // b位置的元素如果不是val就挪到i 如果b是val 赋值-1
                if (nums[b] == val) {
                    nums[b] = -1;
                } else {
                    nums[i] = nums[b];
                    nums[b] = -1;
                }
                b--;
                a++;
            } else {
                // 需要向前走
                i++;
            }
        }
        return nums.length - a;
    }

    public int removeElement官方(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
