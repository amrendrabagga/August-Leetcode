package week3;

import utils.ListNode;

public class Day6_ReorderList {
    public void reorderList(ListNode head) {
        ListNode l1 = head;

        // split link list into 2
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // reverse second half
        ListNode l2 = reverse(slow);

        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            if (l1Next == null)
                break;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4)));

        Day6_ReorderList obj = new Day6_ReorderList();
        obj.reorderList(head);

        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}
