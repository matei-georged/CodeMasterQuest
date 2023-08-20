/*
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        
        int max_sum_dp  = 0;
        int solution    = nums[0];

        for (int num: nums)
        {
            max_sum_dp  = Integer.max(num + max_sum_dp, num);
            solution    = Integer.max(solution, max_sum_dp);
        }

        return solution;
    }
}