#include <vector>
#include <algorithm>
using namespace std;


bool cmp(std::pair< int, std::pair<int, int>> first, std::pair< int, std::pair<int, int>> second)
{
    return first.second.first + first.first < second.second.first + second.first;
}

class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        int n = startTime.size();
        std::vector<std::pair< int, std::pair<int, int>>> intervals;

        for (int i = 0; i < n; ++i)
        {
            intervals.push_back({endTime[i], {startTime[i], profit[i]}});
        }

        std::sort(intervals.begin(), intervals.end());

        int dp[n];
        for (int i = 0; i < n; ++i)
        {
            int start_time  = intervals[i].second.first;
            int end_time    = intervals[i].first;
            int profit_time = intervals[i].second.second;
            
            // std::cout << "(" << start_time << "," << end_time <<")" << " ";
            
            dp[i] = profit_time;
            if (i > 0) {
                dp[i] = max(dp[i], dp[i - 1]);
            }

            int max_index = 1 << 30;
            int bin_index = 0;
            while (max_index)
            {
                if (max_index + bin_index < i && intervals[bin_index + max_index].first <= start_time)
                {
                    bin_index += max_index;
                    dp[i] = std::max(dp[i], dp[bin_index] + profit_time);
                }
                max_index /= 2;
            }

            if (intervals[0].first <= start_time)
            {
                dp[i] = std::max(dp[i], dp[0] + profit_time);
            }
        }

        return dp[n-1];
    }
};