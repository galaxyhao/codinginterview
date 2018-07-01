package codinginterview;

/**
 * 链表中倒数第k个结点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Practice22 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null || k==0)
            return null;

        ListNode fastNode = head;
        ListNode slowNode = head;
        for (int i=0;i<k-1;++i){
            fastNode = fastNode.next;
            if (fastNode == null)
                return null;
        }
        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Practice22 practice22 = new Practice22();
        System.out.println(practice22.FindKthToTail(listNode1,3).val);
    }
}
