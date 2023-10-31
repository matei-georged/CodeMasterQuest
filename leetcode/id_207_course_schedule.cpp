// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
// You are given an array prerequisites where prerequisites[i] = [ai, bi] 
// indicates that you must take course bi first if you want to take course ai.
//     For example, the pair [0, 1], indicates that to take course 0 you have to first 
//     take course 1.
// Return true if you can finish all courses. Otherwise, return false.
#include <vector>
#include <queue>

class Solution
{
public:
    bool canFinish(int numCourses, std::vector<std::vector<int>> &prerequisites)
    {
        std::vector<int> degrees(numCourses, 0);
        std::vector<std::vector<int>> graph(numCourses);
        std::queue<int> que;

        for (int i = 0; i < numCourses; ++i)
        {   
            // b -> a
            int a = prerequisites[i][0];
            int b = prerequisites[i][1]; 
            graph[b].push_back(a);
            degrees[a]++;
        }

        for (int i = 0; i < numCourses; ++i)
        {
            if (degrees[i] == 0)
            {
                que.push(i);
            }
        }

        while (!que.empty())
        {
            int node = que.front();
            que.pop();

            for (auto depend : graph[node])
            {
                degrees[depend]--;
                if (degrees[depend] == 0)
                {
                    que.push(depend);
                }
            }
        }
        
        for (int i = 0; i < numCourses; ++i)
        {
            if (degrees[i] != 0)
            {
                return false;
            }
        }
        
        return true;
    }
};