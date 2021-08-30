package com.leetcode.demo.lpc;

import org.junit.Test;
import java.util.HashMap;

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
public class 最大相等频率 {

    @Test
    public void 自己() {
        int[] nums = new int[]{10, 2, 8, 9, 3, 8, 1, 5, 2, 3, 7, 6};
        for (int i = 0; i < nums.length; i++) {
            // i 是去掉的元素 去掉之后 重新进行排列
            // 1.记录取掉元素之后每个频率最长的长度 循环结束之后 取最大
            int num = nums[i];
            HashMap<Integer, Integer> temp = new HashMap<>();

        }
    }

}
