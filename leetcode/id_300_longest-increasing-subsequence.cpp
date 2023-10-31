/* Given an integer array nums, return the length of the longest \
 * strictly increasing subsequence
 */
#include <vector>

class Solution
{
    class BIT
    {
    public:
        BIT(int n)
        {
            bit.resize(n);
            for (int i = 0; i < n; ++i)
            {
                bit[i] = 0;
            }
        }

        int getMax(int index)
        {
            int sol = 0;
            for (; index > 0; index -= index & -index)
                sol = std::max(sol, bit[index]);

            return sol;
        }

        void update(int index, int val)
        {
            for (; index < bit.size(); index += index & -index)
                bit[index] = std::max(bit[index], val);
        }

    private:
        std::vector<int> bit;
    };

public:
    int lengthOfLIS(std::vector<int> &nums)
    {
        int BASE = 10001;
        BIT bit(BASE * 2);

        for (auto num : nums)
        {
            int longest = bit.getMax(num + BASE - 1);
            bit.update(num + BASE, longest + 1);
        }

        return bit.getMax(BASE * 2 - 1);
    }
};