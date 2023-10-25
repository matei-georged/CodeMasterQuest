#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution
{
    typedef struct
    {
        int start_time;
        int duration;
        int finish_time;
        int index;
    } Task;

public:
    vector<int> getOrder(vector<vector<int>> &tasks)
    {

        std::vector<int> sol;
        std::vector<Task> pTasks;

        int i = 0;
        for (auto task : tasks)
        {
            pTasks.push_back({.start_time = task[0],
                              .duration = task[1],
                              .finish_time = task[0] + task[1],
                              .index = i++});
        }

        std::sort(pTasks.begin(), pTasks.end(), [](Task x, Task y)
                  { return x.start_time < y.start_time; });

        auto cmp = [](Task a, Task b)
        {
            if (a.duration == b.duration)
            {
                return a.index > b.index;
            }
            return a.duration > b.duration;
        };
        std::priority_queue<Task, std::vector<Task>, decltype(cmp)> que(cmp);

        long long time = 0;
        int index = 0;

        do
        {

            while (index < pTasks.size() && pTasks[index].start_time <= time)
            {
                que.push(pTasks[index]);
                index += 1;
            }

            if (que.empty())
            {
                time = pTasks[index].start_time;
                continue;
            }

            if (!que.empty())
            {
                Task curr = que.top();
                que.pop();

                sol.push_back(curr.index);
                time += curr.duration;
            }
        } while (index < pTasks.size() || !que.empty());

        return sol;
    }
};