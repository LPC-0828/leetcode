package com.leetcode.demo.ycq;

import org.junit.Test;

import java.util.*;

/**
 * <p>1224. 最大相等频率
 * 给出一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：
 * <p>
 * 从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 示例:
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4]=5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * <p/>
 *
 * @author Ycq
 * @date: 2021.08.30 09:51
 */
public class MaximumEqualFrequency {

    // 自己写的垃圾方法, 数组长度一多就超出时间限制
    public int maxFrequency(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < nums.length - i; j++) {
                if (!countMap.containsKey(nums[j])) {
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

                if (isSame) {
                    return nums.length - i;
                }
            }
        }
        return 0;
    }


    @Test
    public void test() {
        int[] nums = {1, 1, 2, 2, 2};
        System.out.println(maxEqualFreq(nums));
    }

    /*
     * 看完题解, 我通透了!!!!!!!
     * 1. 创建两个数组, 一个记录频率(每个数字出现的次数), 一个记录频次(每个频率出现的次数),
     * 而且频次是循环过程中一个个记录的, 也就是说: nums = [1, 1, 1], 其实是频率1出现了1次, 频率2出现了一次, 频率3出现了一次
     * 2. 遍历原数组, 通过最高频率和频次的关系判断是否满足条件(符合条件的前缀分为四类), 满足的话就记录下当前的最大长度, 依次往后遍历
     * 2.1. nums = [1, 1, 1, 1, 1], 数组中所有数字全都一样, 最高频率就是前缀长度, 也就是: 最高频率 == i + 1
     * 2.2. nums = [1, 2, 3, 4, 5], 数组中所有数字全都不一样, 所有数的频率都是1, 也就是: 最高频率 == 1
     * 2.3. nums = [1, 1, 2, 2, 3], 只有一个数字的频率是1, 其他数字的频率都相等且大于1, 也就是: 最高频率 * 频次 == i
     * 2.4. nums = [1, 1, 2, 2, 2], 有一个数字的频率比其他频率高1且其他数字的频率都相等, 也就是: 次高频率 * 次高频率的频次 == i
     * */
    private int maxEqualFreq(int[] nums) {
        // 频率
        int[] freqArray = new int[100000];
        // 频次
        int[] freqCountArray = new int[100000];
        // 定义最长长度
        int maxLength = 0;
        // 定义最高频率
        int maxFreq = 0;

        // 遍历原数组
        for (int i = 0; i < nums.length; i++) {
            // 记录频率和频次
            freqCountArray[++freqArray[nums[i]]]++;
            // 设置最大频率
            maxFreq = Math.max(maxFreq, freqArray[nums[i]]);

            // 判断是否符合条件
            if (maxFreq  == i + 1
                    || maxFreq == 1
                    || maxFreq * freqCountArray[maxFreq] == i
                    || (maxFreq - 1) * freqCountArray[maxFreq - 1] == i) {
                // 符合条件, 记录此时的前缀长度, 继续往后遍历, 看看下一个是否还是符合条件
                maxLength = i + 1;
            }
        }

        return maxLength;
    }


}
