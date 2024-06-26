package org.ex.leetcode.array.sumclosest016;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @desc: Sum Closest
 *
 * Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 * 解题思路
 * 标签：排序和双指针
 * 本题目因为要计算三个数，如果靠暴力枚举的话时间复杂度会到 O(n3), 需要降低时间复杂度
 * 首先进行数组排序，时间复杂度 O(nlogn)
 * 在数组 nums 中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
 * 再使用前指针指向 start = i + 1 处，后指针指向 end = nums.length - 1 处，也就是结尾处
 * 根据 sum = nums[i] + nums[start] + nums[end] 的结果，判断 sum 与目标 target 的距离，如果更近则更新结果 ans
 * 同时判断 sum 与 target 的大小关系，因为数组有序，
 *      如果 sum > target 则 end--，
 *      如果 sum < target 则 start++，
 *      如果 sum == target 则说明距离为 0 直接返回结果
 * 整个遍历过程，固定值为 n 次，双指针为 n 次，时间复杂度为 O(n^2)
 * 总时间复杂度：O(nlogn)+ O(n^2) = O(n^2)
 *
 * 作者：画手大鹏
 * 链接：https://leetcode.cn/problems/3sum-closest/solutions/6959/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2024/1/29 11:09
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        // 0. 边界判断
        if (nums.length <3 ) return 0;

        // ans的初始值，他默认取前三个数的和，
        // 然后再用后面更接近target的sum去替换当前的ans，
        // 即使nums[0] + nums[1] + nums[2]正好就是最接近的结果，
        // 也必须要进第一个if里去比较一次。第一轮就会被新的sum给替换掉，节省了一次计算呀（虽然微乎其微…）
        int ans = nums[0] + nums[1] + nums[2];

        // 1. 先排序，从小到大
        Arrays.sort(nums);

        // 2. 准备最外层遍历
        int len = nums.length;
        for (int i =0; i<len; i++){
            // 3. 准备双指针
            int l = i + 1;
            int r = len -1;
            while (l < r ){
                int sum = nums[i] + nums[l] + nums[r];
                // 4. 根据 sum = nums[i] + nums[start] + nums[end] 的结果，
                // 判断 sum 与目标 target 的距离，如果更近则更新结果 ans
                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                // 5. 同时判断 sum 与 target 的大小关系，因为数组有序，
                // 如果 sum > target 则 r--，
                // 如果 sum < target 则 l++，
                // 如果 sum == target 则说明距离为 0 直接返回结果
                if (sum > target){
                    r--;
                }else if(sum < target){
                    l++;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,2,1,-4};
//        int target = 1;
        int[] nums = {0,0,0};
        int target = 1;

        System.out.println(threeSumClosest(nums,target));
    }

}
