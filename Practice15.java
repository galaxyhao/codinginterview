package codinginterview;

/**
 * 二进制中1的个数
 *
 * 题目描述：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Practice15 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            ++count;
            n = (n-1) & n;
        }
        return count;
    }
    public static void main(String[] args) {
        Practice15 practice15 = new Practice15();
        System.out.println(practice15.NumberOf1(9));
    }
}
