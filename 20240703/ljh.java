/**
 * 작성자 : 이재훈
 * 스터디 일시 : 2024/7/03
 * 문제 : https://leetcode.com/problems/add-two-numbers/
 */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode result = null;
        int carry = 0;

        int i=0;
        while (l1 != null || l2 != null) {
            int sum = carry;

            // 두 ListNode 길이가 다를 경우
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum > 9) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }

            if (i == 0) {
                System.out.println("i:"+i + " sum:"+sum);
                node = new ListNode(sum);
                result = node;

            } else {
                System.out.println("i:"+i + " sum:"+sum);
                node.next = new ListNode(sum);
                node = node.next;
            }

            i++;
        }

        // 마지막 항목에 carry 발생할 경우
        if (carry == 1) {
            node.next = new ListNode(1);
        }

        return result;
    }
}