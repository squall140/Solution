package org.ex.leetcode.advance.search.findpeakelement162;

/**
 * @desc: Find Peak Element
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks,just return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always
 * considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 *
 * @author: Leif
 * @date: 2024/2/2 14:43
 */
public class Solution {
    public static int findPeakElement(int[] nums){
        int left = 0, right = nums.length -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            // 逐渐收缩左边界
            if(nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }
}
