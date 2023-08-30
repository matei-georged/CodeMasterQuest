import java.util.HashMap;
/*
 * You are given a 0-indexed integer array nums. In one operation, you can:
 *     Choose two different indices i and j such that 0 <= i, j < nums.length.
 *     Choose a non-negative integer k such that the kth bit (0-indexed) in the binary representation of nums[i] and nums[j] is 1.
 *     Subtract 2k from nums[i] and nums[j].
 * A subarray is beautiful if it is possible to make all of its elements equal to 0 after applying the above operation any number of times.
 * Return the number of beautiful subarrays in the array nums.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        HashMap<Integer, Integer> hashDP = new HashMap<Integer, Integer>();
        long solution = 0;
        int runingSum = 0;

        hashDP.put(Integer.valueOf(0), Integer.valueOf(1));

        for (int num : nums) {
            runingSum = runingSum ^ num;
            
            if (hashDP.containsKey(runingSum)) {
                Integer previousBegins = hashDP.get(runingSum); 
                
                solution += previousBegins.intValue();
                hashDP.put(runingSum, previousBegins + 1);
            } else {
                hashDP.put(Integer.valueOf(runingSum), 1);
            }
        }

        return solution;
    }
}