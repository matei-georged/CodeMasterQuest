// this is the base definition of the node class
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
 
//iterative solution
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {   
        Integer  backCarry          = Integer.valueOf(0);
        ListNode solution           = null;
        ListNode prevPartSolution   = null;

        while (l1 != null || l2 != null || !backCarry.equals(0))
        {
            Integer l1Val = Integer.valueOf(l1 != null ? l1.val : 0);
            Integer l2Val = Integer.valueOf(l2 != null ? l2.val : 0);

            ListNode partSolution = new ListNode(l1Val + l2Val + backCarry);
            
            backCarry = partSolution.val / 10;
            partSolution.val %= 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if (prevPartSolution == null)
            {
                solution = prevPartSolution = partSolution;
                continue;
            }

            prevPartSolution.next = partSolution;
            prevPartSolution = partSolution;
        }

        return solution;
    }
}

//this is another solution that uses recursion to make the solution nicer
class RecursiveSolution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {   
        
        return addTwoNumbersHelper(l1, l2, Integer.valueOf(0));
    }

    public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, Integer backCarry)
    {
        if (l1 == null && l2 == null && backCarry.equals(0))
        {
            return null;
        }

        Integer l1Val = Integer.valueOf(l1 != null ? l1.val : 0);
        Integer l2Val = Integer.valueOf(l2 != null ? l2.val : 0);

        ListNode partSolution = new ListNode(l1Val + l2Val + backCarry);
            
        backCarry = partSolution.val / 10;
        partSolution.val %= 10;

        ListNode frontSolution = addTwoNumbersHelper(            
            l1 != null ? l1.next : null,
            l2 != null ? l2.next : null, 
            backCarry
        );

        partSolution.next = frontSolution;

        return partSolution;
    }
}