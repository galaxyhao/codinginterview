package codinginterview;

/**
 * 打印从1到最大n位数
 *
 * 题目描述：输入数字n，按顺序打印从1到最大n位十进制数。比如输入3，则打印处1、2、3一直到最大数999。
 *
 * 分析：并不是像题目描述这么简单，要考虑大数问题。
 */
public class Practice17 {

    //方法一：常规解法，使用byte数组（字符串）来表示一个大数，模拟数字加一
    public void print1ToMaxOfDigits(int n){
        if (n<=0){
            return;
        }
        byte [] number = new byte[n];
        while (increment(number)){
            print(number);
        }
    }
    public boolean increment(byte[] number){
        int i = number.length-1;
        while (i>=0){
            if (number[i] == 9){
                number[i] = 0;
            }else
            {
                number[i] ++;
                break;
            }
            i--;
        }
        if (i<0){
            return false;
        }
        return true;
    }



    //方法二：使用递归实现数字全排列
    public void print1ToMaxOfDigitsTwo(int n){
        if (n<=0){
            throw new RuntimeException("invalid input");
        }
        byte [] number = new byte[n];
        for (byte i=0;i<10;++i){
            number[0] = i;
            print1ToMaxOfDigitsRecursively(number,n,0);
        }
    }
    public void print1ToMaxOfDigitsRecursively(byte []number,int length,int index){
        if (index == length-1){
            print(number);
            return;
        }
        for (byte i=0;i<10;++i){
            number[index+1] = i;
            print1ToMaxOfDigitsRecursively(number,length,index+1);
        }
    }



    //打印输出
    public void print(byte[] number){
        boolean flag = false;
        for (int i=0;i<number.length;i++){
            if (number[i] != 0){
                flag = true;
                System.out.print(number[i]);
            }else if (number[i]==0 && flag){
                System.out.print(number[i]);
            }
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Practice17 practice17 = new Practice17();
        practice17.print1ToMaxOfDigitsTwo(3);
    }
}
