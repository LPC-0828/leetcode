package com.leetcode.demo.ycq;

import org.junit.Test;

import java.util.Arrays;

/*59. 螺旋矩阵 II
* 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
* */
public class GenerateMatrix {

    // 模拟生成矩阵
    public int[][] generateMatrix(int n) {
        // 生成初始矩阵
        int[][] matrix = new int[n][n];

        // 初始坐标
        int row = 0;
        int column = 0;

        // 初始值
        int currentNum = 1;

        // 定义方向(右下左上) (坐标如何变化)
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 当前方向
        int directionIndex = 0;

        // 填充矩阵
        while (currentNum <= n * n){
            matrix[row][column] = currentNum++;

            // 判断下一个坐标
            int nextRow = row + direction[directionIndex][0];
            int nextColumn = column + direction[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0
                    || nextRow >= n || nextColumn >= n
                    || matrix[nextRow][nextColumn] != 0){

                // 需要顺时针变化方向 一共四个方向, 取模就是direction里的方向循环
                directionIndex = (directionIndex + 1) % 4;
            }

            // 计算下一个坐标(判断方向后)
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }

        return matrix;
    }


    // 模拟2 边界缩进
    public int[][] generateMatrix2(int n) {
        // 定义四个方向的边界
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        // 生成初始矩阵
        int[][] matrix = new int[n][n];
        // 当前值
        int currentNum = 1;
        // 填充矩阵
        while (currentNum <= n * n){
            // 左 -> 右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = currentNum++;
            }
            // top向下缩进1
            top++;

            // 上 -> 下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = currentNum++;
            }
            // right向左缩进1
            right--;
            
            // 右 -> 左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = currentNum++;
            }
            // bottom向上缩进1
            bottom--;

            // 下 -> 上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = currentNum++;
            }
            // left向右缩进1
            left++;
        }

        return matrix;
    }



    @Test
    public void test(){
        int n = 3;
        int[][] matrix = generateMatrix2(n);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
