package hot100;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 最后的测试就是这样的
        // 其实最简单的就是hashMap
        Map<ListNode,Integer> map = new HashMap<>();
        if(headA == null || headB == null){
            return false;
        }
        while(headA !=null){
            map.put(headA,1);
            headA = headA.next;
        }
        while(headB != null){
            if(map.containsKey(headB)){
                return headB
            }
            headb = headB.next;
        }
        return null;
 }
}

