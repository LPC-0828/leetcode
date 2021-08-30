package com.leetcode.demo.ycq;

import org.junit.Test;

import java.util.*;

/**
 * <p>1224. 最大相等频率
 * 给出一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：
 * <p>
 * 从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * <p/>
 *
 * @author Ycq
 * @date: 2021.08.30 09:51
 */
public class MaximumEqualFrequency {

    /*输入：nums = [2,2,1,1,5,3,3,5]
    输出：7
    解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4]=5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
    */

    public int maxFrequency(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < nums.length - i; j++) {
                if (!countMap.containsKey(nums[j])){
                    countMap.put(nums[j], 1);
                } else {
                    countMap.put(nums[j], countMap.get(nums[j]) + 1);
                }
            }

            List<Integer> values = new ArrayList<>(countMap.values());
            boolean isSame = true;
            for (int k = 0; k < values.size(); k++) {
                isSame = true;
                values.set(k, values.get(k) - 1);
                int item = values.get(0) == 0 ? values.get(1) : values.get(0);
                for (Integer value : values) {
                    if (value != item && value != 0) {
                        isSame = false;
                        values.set(k, values.get(k) + 1);
                        break;
                    }
                }

                if (isSame){
                    return nums.length - i;
                }
            }
        }
        return 0;
    }


    @Test
    public void test() {
        int[] nums = {10,2,8,9,3,8,1,5,2,3,7,6};
        System.out.println(maxFrequency(nums));
    }

}
