package hot100;

public class SortList {
    public ListNode sortList(ListNode head){
        // 排序链表
        // 这道题也很简单
        // 用归并排序即可
        // 但是这道题的难点在于如何在O(1)的空间复杂度内完成归并排序
        // 也就是说我们不能用数组来辅助排序
        // 我们可以用快慢指针来找到链表的中间节点
        // 然后把链表分成两个部分
        // 然后对两个部分分别进行排序
        // 最后再把两个部分合并
        return sort(head,null);
    }
    public ListNode sort(ListNode head,ListNode tail){
        // 链表为null或者只有一个节点的时候直接返回
        if(head == null){
            return head;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        // 找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        // 这里的tail是为了防止链表中有环??
        while(fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if(fast!=tail){
                fast = fast.next;
            }
        }
        // 对两个部分分别进行排序
        ListNode mid = slow;
        ListNode list1 = sort(head,mid);
        ListNode list2 = sort(mid,tail);
        // 合并两个部分
        ListNode sorted = merge(list1,list2);
        return sorted;
    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null){
            temp.next = temp1;
        }else if(temp2!=null){
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
