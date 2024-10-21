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
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode mergeList = new ListNode();
        ListNode cur = mergeList;

        while(list1 !=null && list2 !=null ){
            if(list1.val <=list2.val){
                cur.next = list1;   //list1노드를 추가
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 둘중하나 다끝나고 잔여 있는거 +
        if(list1!=null){
            cur.next = list1;
        }
        if(list2!=null){
            cur.next=list2;
        }

        return mergeList.next;

        
    }

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}