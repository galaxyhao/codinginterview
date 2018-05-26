package codinginterview;

/**
 * 剪绳子
 *
 * 题目描述：给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class Practice14 {

    //动态规划解法
    public int solutionOne(int length){
        if (length < 2)
            return 0;
        if(length == 2)
            return 1;
        if (length == 3)
            return 2;
        int [] products = new int[length+1];

        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i=4;i<=length;i++){
            for (int j=0;j<=i/2;j++){
                int product = products[j]*products[i-j];
                if (products[i] < product)
                    products[i] = product;
            }
        }
        return products[length];
    }

    //贪婪算法
    public int solutionTwo(int length){
        if (length < 2)
            return 0;
        if(length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length/3;
        if (length - timesOf3*3 == 1){
            timesOf3 --;
        }
        int timesOf2 = (length-timesOf3*3)/2;

        return (int) (Math.pow(3,timesOf3)*(int) Math.pow(2,timesOf2));
    }
    public static void main(String[] args) {
        Practice14 practice14 = new Practice14();
        int maxNumberOne = practice14.solutionOne(8);
        int maxNumberTwo = practice14.solutionTwo(8);
        System.out.println("One: "+maxNumberOne+", Two: "+maxNumberTwo);
    }
}
