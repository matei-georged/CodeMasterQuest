import java.util.Arrays;

class Solution {
    public int distinctAverages(int[] nums) {
        
        // the max in nums is guaranteed to be 100
        int[] averages = new int[101];
        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(nums, 0, nums.length);
        
        // do the + 1 because the array is zero indexed
        while (i + 1 != j) {
            averages[ (nums[i] + nums[j]) / 2 ] += 1;

            i++;
            j--;
        }

        return Arrays
                .stream(averages)
                .map(x -> (x == 0) ? 0 : 1)
                .sum();
    }
}