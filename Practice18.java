package codinginterview;

public class Practice18 {
    private ListNode DeleteNode(ListNode pListHead, ListNode pToBeDeleted){
        //如果被删除的节点不是尾节点
        if (pToBeDeleted.next != null){
            pToBeDeleted.val = pToBeDeleted.next.val;
            pToBeDeleted.next = pToBeDeleted.next.next;
            return pListHead;
        }
        //如果链表仅存在一个节点
        else if (pListHead == pToBeDeleted){
                return null;
            }
        //如果删除的节点是尾节点
        else {
            ListNode pNode = pListHead;
            while (pNode.next != pToBeDeleted)
                pNode = pNode.next;
            pNode.next = null;
            return pListHead;
        }
    }
    void printList(ListNode listNode){
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        Practice18 practice18 = new Practice18();
        ListNode listNodeOne = new ListNode(1);
        ListNode listNodeTwo = new ListNode(2);
        ListNode listNodeThree = new ListNode(3);
        listNodeOne.next = listNodeTwo;
        listNodeTwo.next = listNodeThree;
        System.out.println("==========================================");
        practice18.printList(listNodeOne);
        System.out.println("==========================================");
        practice18.printList(practice18.DeleteNode(listNodeOne,listNodeTwo));
//        System.out.println("==========================================");
//        practice18.printList(practice18.DeleteNode(listNodeOne,listNodeThree));
//        System.out.println("==========================================");
//        practice18.printList(practice18.DeleteNode(listNodeOne,listNodeOne));
    }
}
