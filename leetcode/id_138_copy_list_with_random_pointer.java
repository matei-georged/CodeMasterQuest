
// Definition for a Node.
/*
 * A linked list of length n is given such that each node contains an additional random pointer, 
 * which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, 
 * where each new node has its value set to the value of its corresponding original node. 
 * 
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list 
 * such that the pointers in the original list and copied list represent the same list state. 
 * 
 * None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * 
 * Return the head of the copied linked list.
 * 
 * The linked list is represented in the input/output as a list of n nodes. 
 * Each node is represented as a pair of [val, random_index] where:
 *      val         : an integer representing Node.val
 *      random_index: the index of the node (range from 0 to n-1) that the random pointer points to, 
 *                    or null if it does not point to any node.
 * 
 * Your code will only be given the head of the original linked list.
 */

// import java.util.HashMap;

// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = null;
        Node lastNewHead = null;

        orgLookup = new HashMap<Node, Integer>();
        newLookup = new HashMap<Integer, Node>();

        // do a copy of the list just with next pointers
        for (Node iterNode = head; iterNode != null; iterNode = iterNode.next) {
            Node nodeCopy = new Node(iterNode.val);
            nodeCopy.next = null;

            if (newHead == null) {
                lastNewHead = newHead = nodeCopy;
            } else {
                lastNewHead.next = nodeCopy;
                lastNewHead = nodeCopy;
            }
        }

        AddRandomness(head, newHead, 0);

        return newHead;
    }

    // this will solve the random part
    void AddRandomness(Node orgHead, Node newHead, int index) {

        if (orgHead == null || newHead == null) {
            return;
        }

        orgLookup.put(orgHead, index);
        newLookup.put(index, newHead);

        AddRandomness(orgHead.next, newHead.next, index + 1);

        Integer indexOfRandom = orgLookup.get(orgHead.random);

        newHead.random = (indexOfRandom != null) ? newLookup.get(indexOfRandom) : null;
    }

    HashMap<Node, Integer> orgLookup;
    HashMap<Integer, Node> newLookup;
}