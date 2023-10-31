#include <vector>
#include <algorithm>
#include <stack>

class Solution {
    typedef struct 
    {
        int pos;
        int vel;
    } Car;

public:
    int carFleet(int target, std::vector<int>& position, std::vector<int>& speed) 
    {
        int n = speed.size();
        std::vector<Car> cars;

        for (int i = 0; i < n; ++i)
        {
            cars.push_back({
                .pos = position[i],
                .vel = speed[i]
            });    
        }

        std::sort(cars.begin(), cars.end(), [](Car a, Car b){
            return a.pos < b.pos;
        });

        std::stack<double> fleets;
        
        for (int i = n - 1; i >= 0; i--)
        {
            double dist = (target * 1.0 - cars[i].pos) / cars[i].vel;
            if (fleets.empty())
            {
                fleets.push(dist);
            } 
            else if (fleets.top() < dist)
            {
                fleets.push(dist);
            }
        }

        return fleets.size();
    }
};