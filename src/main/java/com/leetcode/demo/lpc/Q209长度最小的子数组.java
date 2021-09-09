package com.leetcode.demo.lpc;

import org.junit.Test;

/**
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和>=target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr]
 * 并返回其长度。如果不存在符合条件的子数组，返回 0
 * <p/>
 *
 * @author Ray
 * @date: 2021.09.06 19:04
 */
public class Q209长度最小的子数组 {

    @Test
    public void 自己() {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
//        System.out.println(minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }

    public int minSubArrayLenWhile(int target, int[] nums) {
        int a = 0, b = a + 1, c = 0, sum = nums[a];
        while (b <= nums.length) {
            if (nums[a] >= target) {
                return 1;
            }
            if (a == nums.length - 1 || b == nums.length) {
                return c;
            }
            sum += nums[b];
            if (sum >= target) {
                if (c == 0) c = b - a + 1;
                if (c != 0) c = Math.min(c, b - a + 1);
                a++;
                b = a + 1;
                sum = nums[a];
            } else {
                b++;
            }
        }
        return c;
    }

    public int minSubArrayLenFor(int target, int[] nums) {
        int a = 0, c = 0, sum = nums[a];
        for (int i = 1; i <= nums.length; ) {
            if (nums[a] >= target) {
                return 1;
            }
            if (a == nums.length - 1 || i == nums.length) {
                return c;
            }
            sum += nums[i];
            if (sum >= target) {
                if (c == 0) c = i - a + 1;
                if (c != 0) c = Math.min(c, i - a + 1);
                a++;
                i = a + 1;
                sum = nums[a];
            } else {
                i++;
            }

        }
        return c;
    }


    public int minSubArrayLen(int target, int[] nums) {
        int a = 0, c = 0, sum = nums[a];
        for (int i = 1; a < nums.length; ) {
            if (sum >= target) {
                if (c != 0) c = Math.min(c, i - a);
                if (c == 0) c = i - a;
                sum -= nums[a++];
            } else {
                if (i == nums.length) {
                    return c;
                }
                sum += nums[i++];
            }
        }
        return c;
    }
}
