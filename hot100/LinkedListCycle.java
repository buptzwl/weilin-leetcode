package hot100;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        // 这道题也很简单
        // 快慢指针即可
        // 如果列表中有环的话快指针终将碰到慢指针
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null&&fast.next!=null){
            if(slow == fast){
                return true;
            }
            slow =slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
