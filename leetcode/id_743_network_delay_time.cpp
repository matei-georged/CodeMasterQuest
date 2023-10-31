#include <vector>
#include <queue>
#include <limits>
/*
 * You are given a network of n nodes, labeled from 1 to n.
 * You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node,
 * and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 */

class Solution
{
    typedef struct
    {
        int w;
        int node;
    } WEdge;

public:
    // times[i] = (ui, vi, wi)
    int networkDelayTime(std::vector<std::vector<int>> &times, int n, int k)
    {
        std::vector<int> dist(n + 1, std::numeric_limits<int>::max());
        std::vector<int> viz(n + 1, 0);
        std::vector<std::vector<WEdge>> graph(n + 1);
        int sol = -1;

        for (int i = 0; i < times.size(); ++i)
        {
            int ui = times[i][0];
            int vi = times[i][1];
            int wi = times[i][2];
            graph[ui].push_back({.w = wi,
                                 .node = vi});
        }

        auto cmp = [](WEdge first, WEdge second) { return first.w > second.w; };
        std::priority_queue<WEdge, std::vector<WEdge>, decltype(cmp)> que(cmp);

        dist[k] = 0;
        que.push({.w = 0,
                  .node = k});

        while (!que.empty())
        {
            int node = que.top().node;
            int w = que.top().w;
            que.pop();

            if (viz[node])
                continue;

            viz[node] = 1;
            for (auto depend : graph[node])
            {
                if (dist[depend.node] > dist[node] + depend.w)
                {
                    dist[depend.node] = dist[node] + depend.w;
                    que.push(
                        {.w = dist[depend.node],
                         .node = depend.node});
                }
            }
        }

        for (int i = 1; i <= n; ++i)
        {
            sol = std::max(sol, dist[i]);
        }

        return sol == std::numeric_limits<int>::max() ? -1 : sol;
    }
};