import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array target and an integer n.
 * You have an empty stack with the two following operations:
 *      "Push": pushes an integer to the top of the stack.
 *      "Pop": removes the integer on the top of the stack.
 * You also have a stream of the integers in the range [1, n].
 *  Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target.
 */

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> solution = new LinkedList<String>();
        
        int stack_top = 0;

        for (int i = 0; i < target.length; ++i) {

            for ( int j = 0; j < target[i] - stack_top - 1; ++j) {
                solution.add("Push");
                solution.add("Pop");
            }

            solution.add("Push");
            stack_top = target[i];
            
        }
        
        return solution;
    }
}