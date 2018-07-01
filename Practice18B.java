package codinginterview;

/**
 * 删除链表中的重复节点
 */
public class Practice18B {
    private ListNode DeleteDuplication(ListNode pHead){
        if (pHead == null)
            return null;
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode != null){
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext!=null && pNext.val==pNode.val)
                needDelete = true;
            if (!needDelete){
                pPreNode = pNode;
                pNode = pNext;
            }else {
                int value = pNode.val;
                ListNode pToBeDel = pNode;
                //循环删除val相同的节点
                while (pToBeDel!=null && pToBeDel.val==value){
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                //头结点被删除
                if (pPreNode == null)
                    pHead = pNext;
                else
                    pPreNode.next = pNext;
                pNode = pNext;
            }
        }
        return pHead;
    }

    public static void main(String[] args) {
        Practice18B practice18B = new Practice18B();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        ListNode pHead = practice18B.DeleteDuplication(listNode1);
        ListNode pNode = pHead;
        while (pNode != null){
            System.out.println(pNode.val);
            pNode = pNode.next;
        }
    }
}
