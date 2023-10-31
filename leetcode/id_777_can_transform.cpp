#include <string>
#include <algorithm>
using namespace std;

class Solution
{
public:
    bool canTransform(string start, string end)
    {

        int r_count = 0;
        int l_count = 0;

        if (start.length() != end.length())
        {
            return false;
        }

        for (int i = 0; i < start.length(); ++i)
        {
            if (start[i] == 'L') l_count++;
            if (end[i]   == 'L') l_count--;

            if (start[i] == 'R') r_count++;
            if (end[i]   == 'R') r_count--;
            
            if (l_count > 0 || r_count < 0 
            || (l_count < 0 && end[i] == 'R') 
            || (r_count > 0 && end[i] == 'L'))
            {
                return false;
            }
        }
        
        return (l_count) == 0 && (r_count == 0);
    }
};