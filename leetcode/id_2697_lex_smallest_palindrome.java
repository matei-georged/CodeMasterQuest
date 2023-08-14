/*
 * You are given a string s consisting of lowercase English letters, and you are allowed to perform operations on it. 
 * In one operation, you can replace a character in s with another lowercase English letter.
 * Your task is to make s a palindrome with the minimum number of operations possible. 
 * If there are multiple palindromes that can be made using the minimum number of operations, make the lexicographically smallest one.
 */
class Solution {
    public String makeSmallestPalindrome(String s) {
        int    n        = s.length();
        char[] solution = s.toCharArray();

        for(int i = 0; i < n/2; ++i)
        {   
            char leftChar   = solution[i];
            char rightChar  = solution[n-i-1];

            solution[i] = solution[n-i-1] = leftChar > rightChar ? rightChar : leftChar;
        }

        return String.valueOf(solution);
    }
}