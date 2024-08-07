import java.util.HashMap;

/**
 * 작성자 : 이지수
 * 스터디 일시 : 2024/7/03
 * 문제 : https://leetcode.com/problems/add-two-numbers/
 */

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
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            stack.add(sum % 10);
            sum = sum / 10;
        }

        if (sum != 0) {
            stack.add(sum);
        }

        ListNode listNode = new ListNode(stack.pop());

        while (!stack.empty()) {
            listNode = new ListNode(stack.pop(), listNode);
        }

        return listNode;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode one = new ListNode();
        ListNode two = one;

        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            two.next = new ListNode(sum % 10);
            sum = sum / 10;
            two = two.next;
        }

        if (sum != 0) {
            two.next = new ListNode(sum % 10);
        }

        return one.next;
    }
}