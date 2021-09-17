package com.leetcode.demo.ycq.array;

import org.junit.Test;

import java.io.*;

/*209. 长度最小的子数组
*给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 

示例 1：

输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
*
* */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int len = 0;
        for (int right = 0; right < nums.length; right++) {
            if (left == 0 && right == 0) {
                sum = nums[left];
            }
            if (sum >= target){
                if (len != 0){
                    len = Math.min(len, right - left + 1);
                } else {
                    len = right - left + 1;
                }

                right--;
                sum -= nums[left];
                left++;
            } else if (right+1 < nums.length){
                sum += nums[right+1];
            }
        }

        return len;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }

    @Test
    public void tests() throws IOException {
        File file = new File("F:\\zml1\\图片");
        int index = 313;
        if (file.isDirectory()){
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            for (File listFile : file.listFiles()) {
                fileInputStream = new FileInputStream(listFile);
                fileOutputStream = new FileOutputStream(new File("F:\\zml1\\1\\00" + index++ + ".png"));
                byte[] buffer = new byte[4028];
                int len = 0;
                while ((len = fileInputStream.read(buffer)) != -1){
                    fileOutputStream.write(buffer, 0, len);
                }

            }
            fileInputStream.close();
            fileOutputStream.close();
        }

    }
}
