package codinginterview;

/**
 * 矩形覆盖
 *
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Practice10D {
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        int rectFirst = 1;
        int rectTwo = 2;
        int count = 0;
        for (int i=3;i<=target;i++){
            count = rectFirst+rectTwo;
            rectFirst = rectTwo;
            rectTwo = count;
        }
        return count;
    }
}
