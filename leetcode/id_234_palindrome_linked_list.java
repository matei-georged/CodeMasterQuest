/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 */
// this is o(n) time, o(1) space
// we need to find the middle of the list. we then reverse the second half we compare element wise.
class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head, fast = head;

        //we find the middle by going twice as fast with a pointer. the Slow pointer is going to be the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;
        }

        ListNode prev = null, temp = null;
        while (slow != null && slow.next != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        if (slow != null) {
            slow.next = prev;
        }

        fast = head;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }
        return true;

    }
}

// this is o(n) time, o(n) space
class Solution2 {

    public Solution2() {
        mHead = null;
    }

    public boolean isPalindrome(ListNode head) {

        if (mHead == null)
            mHead = head;

        if (head == null)
            return true;

        boolean outterPart = isPalindrome(head.next);

        if (!outterPart || mHead.val != head.val)
            return false;

        mHead = mHead.next;

        return true;
    }

    ListNode mHead;

}