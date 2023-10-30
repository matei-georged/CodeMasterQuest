/* Given an integer array nums, return true if you can partition the array
 * into two subsets such that the
 * sum of the elements in both subsets is equal or false otherwise.
 */
#include <vector>

class Solution
{
public:
    bool canPartition(std::vector<int> &nums)
    {
        int total = 0;

        for (auto num : nums)
        {
            total += num;
        }

        std::vector<int> dp(total + 1, 0);
        dp[0] = 1;
        
        for (auto num : nums)
        {
            for (int i = total; i >= num;  i--)
            {
                if (dp[i - num] == 1)
                {
                    dp[i] = 1;
                }

                if (dp[i] == 1 && dp[i] == (total - i))
                {
                    return true;
                }
            }
        }
        return false;
    }
};