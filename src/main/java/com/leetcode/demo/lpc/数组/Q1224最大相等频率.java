package com.leetcode.demo.lpc.数组;

import org.junit.Test;

/**
 * <p>
 * 给出一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度
 * 从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * <p/>
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4]=5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 *
 * @author Ray
 * @date: 2021.08.30 09:52
 */
public class Q1224最大相等频率 {

    @Test
    public void 自己() {
        System.out.println(maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
    }

    /**
     * 解题思路 判断每个下标 判断当前下标、最高频率 是否满足四种规律 如果满足 说明当前的i元素去掉之后的长度是最长前缀 i是下标 +1就是最长前缀
     * 怎么掌握这个数据的规律 下标i 最高频率rate 次高频率次rate 最高频率的频次fre 次高频率的频次次fre  最长前缀len
     * [1]           i==0 rate==1 次rate==0 fre==1 次fre==0 len==1 规律是 rate==i+1
     * [1,1]         i==1 rate==2 次rate==1 fre==2 次fre==1 len==2 规律是 rate==i+1
     * [1,2]         i==1 rate==1 次rate==0 fre==2 次fre==0 len==2 规律是 rate==1
     * [1,2,3,4]     i==3 rate==1 次rate==0 fre==4 次fre==0 len==4 规律是 rate==1
     * [1,1,2]       i==2 rate==2 次rate==1 fre==2 次fre==2 len==3 规律是 rate * fre ==i 最高频率 * 最高频率的频次 = i
     * [1,1,2,2,3]   i==4 rate==2 次rate==1 fre==2 次fre==2 len==5 规律是 rate * fre ==i 最高频率 * 最高频率的频次 = i
     * [1,1,2,2,2]   i==4 rate==3 次rate==2 fre==1 次fre==2 len==5 规律是 次rate * 次fre ==i 次高频率 * 次高频率的频次 = i
     * [1,1,2,2]     i==3 rate==2 次rate==1 fre==2 次fre==2 len==3 不符合要求
     * [1,2,2,3,3,3] i==5 rate==3 次rate==2 fre==1 次fre==2 len==5 不符合要求
     */
    public int maxEqualFreq(int[] nums) {
        // 下标是数字 value是数字出现的频率
        int[] rate = new int[10000];
        // 下标是频率 value是频率出现的频次
        int[] fre = new int[10000];
        // 最长前缀
        int len = 0;
        // 最高频率
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前数字
            int num = nums[i];
            // 当前数字出现频率+1
            // 当前数字出现的频率的频次+1
            fre[++rate[num]]++;
            // 拿出最高频率 方便判断是否满足条件
            max = Math.max(max, rate[num]);
            if (max == i + 1
                    || max == 1
                    || max * fre[max] == i
                    || (max - 1) * fre[max - 1] == i) {
                len = i + 1;
            }
        }
        return len;
    }
}
