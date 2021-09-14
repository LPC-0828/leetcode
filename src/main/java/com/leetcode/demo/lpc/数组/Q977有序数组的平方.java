package com.leetcode.demo.lpc.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p/>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * @author Ray
 * @date: 2021.09.03 18:39
 */
public class Q977有序数组的平方 {

    @Test
    public void 自己() {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    /**
     * 思路是从两头一起开始 存一个最大的放最后面
     * 先平方后判断不需要考虑负数
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int cc = nums.length - 1;
        // 双指针排序 一边平方一遍排序
        int a = 0, b = nums.length - 1;
        while (cc != -1) {
            int numa = nums[a] * nums[a];
            int numb = nums[b] * nums[b];
            if (numb > numa) {
                result[cc] = numb;
                b--;
            } else {
                result[cc] = numa;
                a++;
            }
            cc--;
        }
        return result;
    }

}
