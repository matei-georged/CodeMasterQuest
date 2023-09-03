class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0; 
        int j = 0;
        int n = nums.length;
        int max = 0;
        int nums_of_zeros = 0;


        for (int num : nums) {
            
            j++;
            nums_of_zeros += 1 - num;

            while (nums_of_zeros > 1)
            {
                if (nums[i] == 0)
                {
                    nums_of_zeros -= 1;
                }
                i++;
            }

            max = Integer.max(max, j - i);
        }

        return max;
    }
}