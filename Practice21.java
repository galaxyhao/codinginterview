package codinginterview;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分。
 */
public class Practice21 {
    public void reOrderArray(int [] array) {
        if (array == null)
            return;
        int left = 0;
        int right = array.length-1;

        while (right > left){
            while (right>left && array[right]%2==0)
                --right;
            while (right>left && array[left]%2==1)
                ++left;
            if(right > left){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }

        }
    }

    public static void main(String[] args) {
        Practice21 practice21 = new Practice21();
        int [] array1 = {1,2,3,4,5,6,7};
        practice21.reOrderArray(array1);
        for (int number:array1) {
            System.out.println(number);
        }
    }
}
