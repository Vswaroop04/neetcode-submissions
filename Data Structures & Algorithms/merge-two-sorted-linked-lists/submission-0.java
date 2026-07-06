class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pt1 = list1;
        ListNode pt2 = list2;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (pt1 != null && pt2 != null) {
            if (pt1.val <= pt2.val) {
                tail.next = pt1;
                pt1 = pt1.next;
            } else {
                tail.next = pt2;
                pt2 = pt2.next;
            }
            tail = tail.next;
        }

        if (pt1 != null) {
            tail.next = pt1;
        } else {
            tail.next = pt2;
        }

        return dummy.next;
    }
}