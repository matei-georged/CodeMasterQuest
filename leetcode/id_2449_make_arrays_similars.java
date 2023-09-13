import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);

        long odd_subproblem = 
            solve( Arrays.stream(nums).filter( a -> a % 2 == 1).toArray()
                  ,Arrays.stream(target).filter( a -> a % 2 == 1).toArray());

        long even_subproblem = 
            solve( Arrays.stream(nums).filter( a -> a % 2 == 0).toArray()
                  ,Arrays.stream(target).filter( a -> a % 2 == 0).toArray());

        return (odd_subproblem + even_subproblem) / 2;
    }

    public long solve(int[] nums, int[] target) {
        long solution = 0;

        for (int i = 0; i < nums.length; i++) {
            solution += Math.abs(nums[i] - target[i]) / 2;
        }

        return solution;
    }

}