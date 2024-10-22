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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(); // 빈 리스트에다가 머지할것임.
       if (list1.val <= list2.val) {
           newList.val = list1.val;
           list1 = list1.next;
       } else {
           newList.val = list2.val;
           list2 = list2.next;
       }
        
        
        // 앞에서부터 하나씩 비교
        while (list1.next != null && list2.next != null) {
            if (list1.val <= list2.val) {
                newList.next = list1;
                list1 = list1.next;
            } else {
                newList.next = list2;
                list2  = list2.next;
            }
        }
        
        if (list1 != null) {
            newList.next = list1;
        } else {
            newList.next = list2;
        }
        
        return newList;
    }
}