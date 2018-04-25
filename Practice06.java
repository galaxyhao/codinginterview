package codinginterview;

class TreeNode {
    private int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Practice06 {
    private TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre || startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Practice06 practice06 = new Practice06();

        TreeNode treeNode = practice06.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}
