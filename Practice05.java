package codinginterview;

import java.util.ArrayList;
import java.util.Stack;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Practice05 {
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(printListFromTailToHead(new ListNode(1)));
    }
}
