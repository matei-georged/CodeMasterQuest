#include <string>

class Solution
{
public:
    int index;

    Solution()
    {
        index = 0;
    }

    std::string decodeString(std::string s)
    {
        std::string sol = "";
        int n = s.length();

        while (index < n)
        {
            int repeat = 0;

            //case 1, we have a string
            while (index < n && 'a' <= s[index] && s[index] <= 'z')
            {
                sol += s[index++];
            }

            //case 2, we have multiplicity
            while (index < n && '0' <= s[index] && s[index] <= '9')
            {
                repeat = repeat * 10 + (s[index++] - '0');
            }

            //case 3, we hit the end of a repetition
            if (index < n && s[index] == ']')
            {
                index++;
                return sol;
            }

            //we have to start a new repetition, get the expanded string inside 
            //and add it k times
            if (index < n && s[index] == '[')
            {
                index++;
                std::string to_repeat = decodeString(s);
                for (int i = 0; i < repeat; ++i)
                {
                    sol += to_repeat;
                }
            }
        }

        return sol;
    }
};