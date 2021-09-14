package com.leetcode.demo.lpc.数组;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p/>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * @author Ray
 * date: 2021.09.09 19:49
 */
public class Q59螺旋矩阵 {

    @Test
    public void 自己() {
        System.out.println(Arrays.deepToString(generateMatrix(13)));
    }

    /**
     * 异常用来控制第一圈 防止越界
     * &&后面用来控制往里走
     */
    public int[][] generateMatrix(int n) {
        // 0右 1下 2左 3上
        int 方向 = 0;
        int value = 1;
        int 横坐标 = -1, 纵坐标 = 0;
        int[][] result = new int[n][n];
        while (value <= n * n) {
            try {
                while (方向 == 0) {
                    // 纵坐标不动 横坐标++
                    for (int i = 横坐标; (i < n - 1 || result[纵坐标][i + 1] == 0) && result[纵坐标][i + 1] == 0; ) {
                        result[纵坐标][++i] = value++;
                        横坐标 = i;
                    }
                    方向 = 1;
                }
            } catch (Exception e) {
                方向 = 1;
            }

            try {
                while (方向 == 1) {
                    // 横坐标不动 纵坐标++
                    for (int i = 纵坐标; (i < n - 1 || result[i + 1][横坐标] == 0) && result[i + 1][横坐标] == 0; ) {
                        result[++i][横坐标] = value++;
                        纵坐标 = i;
                    }
                    方向 = 2;
                }
            } catch (Exception e) {
                方向 = 2;
            }
            try {
                while (方向 == 2) {
                    // 纵坐标不动 横坐标--
                    for (int i = 横坐标; result[纵坐标][i - 1] == 0; ) {
                        result[纵坐标][--i] = value++;
                        横坐标 = i;
                    }
                    方向 = 3;
                }
            } catch (Exception e) {
                方向 = 3;
            }
            try {
                while (方向 == 3) {
                    // 横坐标不动 纵坐标--
                    for (int i = 纵坐标; result[i - 1][横坐标] == 0; ) {
                        result[--i][横坐标] = value++;
                        纵坐标 = i;
                    }
                    方向 = 0;
                }
            } catch (Exception e) {
                方向 = 0;
            }
        }

        return result;
    }
}