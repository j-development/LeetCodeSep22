package johan.ekdahl;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;


        boolean carry = false;

        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 == null){
                sum = l2.val;
                l2 = l2.next;

            }
            else if(l2 == null){
                sum = l1.val;
                l1 = l1.next;
            }
            else{
                sum = l1.val+l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(carry){
                sum = sum+1;
                carry = false;
            }
            if(sum > 9){
                sum = sum-10;
                carry = true;
            }
            l3 = insert(l3,sum);
        }
        if(carry){
            l3 = insert(l3,1);
        }

        return l3;
    }

    public static ListNode insert(ListNode l, int val){
        ListNode lnew = new ListNode(val);

        if(l == null){
            l = lnew;
        }
        else{
            ListNode last = l;
            while(last.next != null){
                last = last.next;
            }
            last.next = lnew;
        }
        return l;

    }

}