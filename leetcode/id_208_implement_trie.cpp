/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 */
#include <map>
#include <string>

class Trie
{

public:
    struct Node
    {
        std::map<char, Node *> a;
        bool flag;

        Node() { flag = false; }
    } nod;

    Trie()
    {
    }

    void insert(std::string word)
    {
        Node* workingNode = &nod;
        for (int i = 0; i < word.size(); ++i)
        {
            if (workingNode->a.count(word[i]) == 0)
            {
                workingNode->a[word[i]] = new Node();
            }
            workingNode = workingNode->a[word[i]];
        }
        workingNode->flag = true;
    }

    bool search(std::string word)
    {
        Node* workingNode = &nod;
        for (int i = 0; i < word.size(); ++i)
        {
            if (workingNode->a.count(word[i]) == 0)
            {
                return false;
            }
            workingNode = workingNode->a[word[i]];
        }

        return workingNode->flag;
    }

    bool startsWith(std::string prefix)
    {
        Node* workingNode = &nod;
        for (int i = 0; i < prefix.size(); ++i)
        {
            if (workingNode->a.count(prefix[i]) == 0)
            {
                return false;
            }
            workingNode = workingNode->a[prefix[i]];
        }
        
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */