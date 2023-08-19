/* You are given an integer array num. You are initially positioned at the array's first index, and 
* each element in the array represents your maximum jump length at that position.
* Return true if you can reach the last index, or false otherwise.
*
* Solution:
* The idea is to traverse the array from the back to front and keep track of the lowest position from which we can reach
* the end. Now, if we ar at index k, we have a max jump of num[k]. The max index that we can reach is k + num[k].
* If we can reach the minimum index that would lead to a solution, we update the min index. We return true if at the end
* we end up with the minimum valid position of 0
*/

class Solution {
    public boolean canJump(int[] nums) {
        int len                 = nums.length;
        int minIndexValidJump   = len - 1;

        for (int i = len - 1; i >= 0; --i)
        {
            if (nums[i] + i >= minIndexValidJump)
            {
                minIndexValidJump = i;
            }
        }
        return minIndexValidJump == 0;
    }
}