package com.leetcode.demo.lpc.数组;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p/>
 *
 * @author Ray
 * @date: 2021.09.01 19:45
 */
public class Q1两数之和 {

    @Test
    public void 自己() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (temp.containsKey(i1)) {
                ints[0] = temp.get(i1);
                ints[1] = i;
                break;
            } else if (!temp.containsKey(nums[i])) {
                // 值，下标
                temp.put(nums[i], i);
                // 如果出现了等于 就直接return下标
            }
        }
        return ints;
    }
}
