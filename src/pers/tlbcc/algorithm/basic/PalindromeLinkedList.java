package pers.tlbcc.algorithm.basic;

/**
 * @author tlbcc
 * @description leetcode 234 回文链表
 * @date 2024-3-27 14:34
 */
public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        int arr[] = new int[100000];
        ListNode node = head;
        int i = 0;
        for (; node != null; i++) {
            arr[i] = node.val;
            node = node.next;
        }
        int arrEndIndex = i - 1;
        int l = 0;
        int r = arrEndIndex;
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome_fastest(ListNode head) {
        //Only one node in the list
        if (head == null || head.next == null) return true;

        //Only two node in the list
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        ListNode fast;
        ListNode slow;

        fast = head.next.next;
        slow = head;

        //Get the center of the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse second half of the list
        ListNode pre = null;
        ListNode temp;
        ListNode current = slow.next;
        while (current != null) {
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        //Compare the first half and the second half
        while (pre != null) {
            if (head.val == pre.val) {
                head = head.next;
                pre = pre.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        test(new int[]{1, 2, 3, 2, 3, 2, 1});
        test(new int[]{1, 2, 3, 3, 2, 1});
    }

    public static void test(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        boolean flag = isPalindrome(head);
        System.out.println(flag);
    }

}
