#include <vector>
#include <cstdlib>
#include <ctime>
#include <cmath>

class Solution {
public:
    Solution(std::vector<int>& w) {
        
        int sum = 0;
        for (auto ww : w)
        {
            sum += ww;
            mPartialSums.push_back(sum);
        }
    }
    
    int pickIndex() {
        
        std::srand(std::time(nullptr)); 
        int uniform_rand = (1 + std::rand() * mMax / RAND_MAX )% (mMax + 1);

        int sol = 0;
        int step = 1 << 30;

        while (step)
        {
            if (sol + step < mPartialSums.size() && mPartialSums[sol+step] <= uniform_rand) {
                sol += step;
            }
            step /= 2;
        }

        return std::min(sol + 1, (int)mPartialSums.size() - 1);
    }

    std::vector<int> mPartialSums;
    int mMax;
};