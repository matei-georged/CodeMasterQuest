class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int left_prefix[nums.size()];
        int right_prefix[nums.size()];
        
        left_prefix[0] = nums[0];
        for (int i = 1; i < nums.size(); ++i)
        {
            left_prefix[i] = nums[i] * (left_prefix[i-1] == 0 ? 1 : left_prefix[i-1]);
        }

        right_prefix[nums.size()-1] = nums[nums.size()-1];
        for (int i = nums.size() - 2; i >= 0; --i)
        {
            right_prefix[i] = nums[i] * (right_prefix[i+1] == 0 ? 1 : right_prefix[i+1]);
        }

        int res = nums[0];

        for(int i = 0; i < nums.size(); ++i)
        {
            res = max(res, right_prefix[i]);
            res = max(res, left_prefix[i]);
        }

        return res;

    }
};