package org.ex.leetcode.advance.search.searcha2dmatrixii240;

/**
 * @desc: Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value target in an m * n integer matrix.
 * This matrix has the following properties:
 *  - Integers in each row are sorted in ascending from left to right.
 *  - Integers in each column are sorted in ascending from top to bottom.
 *
 * Example1:
 * <img src = "https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg" />
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 * 思路 二分法
 * 因为每行单调有序，就按每行二分查
 *
 * @author: Leif
 * @date: 2024/2/2 14:18
 */
public class Solution02 {
    public static boolean searchMatrix(int[][] matrix, int target){
        for(int[] row : matrix){
             int index = binarySearch(row, target);
             if (index != -1 ) return true;
        }
        return false;
    }

    public static int binarySearch(int[] matrix, int target ){
        int left =0, right = matrix.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[mid] < target){
                left = mid + 1;
            }else if (matrix[mid] > target){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }
}
