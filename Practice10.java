package codinginterview;

/**
 * 斐波那契数列
 */
public class Practice10 {
    private static int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        int first = 0;
        int second = 1;
        int num = 0;
        for (int i=2;i<=n;i++){
            num = first + second;
            first = second;
            second = num;
        }
        return num;
    }

    private static void test01(){
        System.out.println(Fibonacci(0));
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(10));
    }

    public static void main(String[] args) {
        test01();
    }
}
