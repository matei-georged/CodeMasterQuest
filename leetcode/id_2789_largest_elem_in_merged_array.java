/*
 * You are given a 0-indexed array nums consisting of positive integers. 
 * You can do the following operation on the array any number of times:
 * Choose an integer i such that 0 <= i < nums.length - 1 and nums[i] <= nums[i + 1]. 
 * Replace the element nums[i + 1] with nums[i] + nums[i + 1] and delete the element nums[i] from the array.
 * Return the value of the largest element that you can possibly obtain in the final array.
 */
class Solution {
    public long maxArrayValue(int[] nums) {
        long solution = 0;

        for (int index = nums.length - 1; index >= 0; --index)
        {
            solution = solution >= nums[index] ? solution + nums[index] : nums[index];
        }

        return solution;
    }
}