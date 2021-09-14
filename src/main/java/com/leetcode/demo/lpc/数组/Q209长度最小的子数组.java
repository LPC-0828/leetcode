package com.leetcode.demo.lpc.数组;

import org.junit.Test;

import java.util.Arrays;

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

    /**
     * 先对数组做处理 挨个计算和 重新弄出一个数组
     * 再用tar挨个加 找到第一个比tar大的位置 这个位置到当前下标位置 就是最短距离
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen二分(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
