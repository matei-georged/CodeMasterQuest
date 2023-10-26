#include <vector>
#include <algorithm>
#include <map>
#include <queue>
using namespace std;

// Definition for Employee.
// class Employee {
// public:
//     int id;
//     int importance;
//     vector<int> subordinates;
// };

class Solution {
public:
    std::map<int, Employee*> graph;
    std::vector<int> visited_emp;

    Solution() : visited_emp(2001, 0)
    {

    }

    int getImportance(vector<Employee*> employees, int id) 
    {
        for (auto emp : employees)
        {
            graph[emp->id] = emp;
        }

        return importance_dfs(id);
    }

    int importance_dfs(int id)
    {   
        int sol = 0;

        if (visited_emp[id] == 1) return 0;
        else visited_emp[id] = 1;

        sol = graph[id]->importance;
        for (auto sub : graph[id]->subordinates) {
            if (!visited_emp[graph[sub]->id]) {
                sol += importance_dfs(graph[sub]->id);
            }
        }

        return sol;
    }

};