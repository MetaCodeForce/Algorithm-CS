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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answer = new ListNode();
        ListNode merge = answer;

        while (list1 != null) {

            while (list2 != null && list1.val >= list2.val) {
                merge.next = new ListNode(list2.val);
                merge = merge.next;
                list2 = list2.next;
            }
            merge.next = new ListNode(list1.val);
            merge = merge.next;
            list1 = list1.next;
        }

        if (list2 != null) {
            merge.next = list2;
        }

        return answer.next;
    }
}