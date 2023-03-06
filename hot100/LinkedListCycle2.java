package hot100;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        do{
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }while(slow != fast);
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
