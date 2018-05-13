package codinginterview;

/**
 * 二叉树的下一个节点
 */
class TreeLinkNode {
    int val = 0;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Practice08 {
    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode pNext = null;

        if(pNode.right != null){
            TreeLinkNode pRight;
            pRight = pNode.right;
            while (pRight.left != null){
                pRight = pRight.left;
            }
            pNext = pRight;
        }else if (pNode.next != null){
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent!=null && pCurrent==pParent.right){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }

    public static void main(String[] args) {
        test01();
    }
    private static void assemble(TreeLinkNode node,
                                 TreeLinkNode left,
                                 TreeLinkNode right,
                                 TreeLinkNode parent) {
        node.left = left;
        node.right = right;
        node.next = parent;
    }
    public static void test01(){
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8); // 4
        TreeLinkNode n9 = new TreeLinkNode(9); // 2
        TreeLinkNode n10 = new TreeLinkNode(10); // 5
        TreeLinkNode n11 = new TreeLinkNode(11); // 1
        TreeLinkNode n12 = new TreeLinkNode(12); // 6
        TreeLinkNode n13 = new TreeLinkNode(13); // 3
        TreeLinkNode n14 = new TreeLinkNode(14); // 7
        TreeLinkNode n15 = new TreeLinkNode(15); // null

        assemble(n1, n2, n3, null);
        assemble(n2, n4, n5, n1);
        assemble(n3, n6, n7, n1);
        assemble(n4, n8, n9, n2);
        assemble(n5, n10, n11, n2);
        assemble(n6, n12, n13, n3);
        assemble(n7, n14, n15, n3);
        assemble(n8, null, null, n4);
        assemble(n9, null, null, n4);
        assemble(n10, null, null, n5);
        assemble(n11, null, null, n5);
        assemble(n12, null, null, n6);
        assemble(n13, null, null, n6);
        assemble(n14, null, null, n7);
        assemble(n15, null, null, n7);

        System.out.println(GetNext(n1));
        System.out.println(GetNext(n2));
        System.out.println(GetNext(n3));
        System.out.println(GetNext(n4));
        System.out.println(GetNext(n5));
        System.out.println(GetNext(n6));
        System.out.println(GetNext(n7));
        System.out.println(GetNext(n8));
        System.out.println(GetNext(n9));
        System.out.println(GetNext(n10));
        System.out.println(GetNext(n11));
        System.out.println(GetNext(n12));
        System.out.println(GetNext(n13));
        System.out.println(GetNext(n14));
        System.out.println(GetNext(n15));
    }
}