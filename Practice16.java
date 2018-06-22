package codinginterview;

/**
 * 数值的整数次方
 *
 * 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 分析：题目很简单，但需要考虑一些临界情况，比如base为0并且exponent为0的情况，exponent不为正的情况。
 */

public class Practice16 {
    public boolean g_InvalidInput = true;

    //传统方法
    public double Power(double base, int exponent) {
        if (Math.abs(base-0.0)<=0 && exponent<0){
            g_InvalidInput =false;
            return 0;
        }
        int absExponent = Math.abs(exponent);

        double result = 1.0;
        for (int i=1;i<=absExponent;i++){
            result = result*base;
        }
        if (exponent < 0){
            result = 1.0/result;
        }
        return result;
    }

    //使用数学公式递归求解，O(logn)
    public double PowerTwo(double base, int exponent){
        if (Math.abs(base-0.0)<=0 && exponent<0){
            g_InvalidInput =false;
            return 0;
        }
        int absExponent = Math.abs(exponent);

        double result = PowerWithUnsignedExponent(base, absExponent);


        return result;
    }

    public double PowerWithUnsignedExponent(double base,int exponent){
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        Practice16 practice16 = new Practice16();
        System.out.println(practice16.Power(1.0,-2));
        System.out.println(practice16.PowerTwo(1.0,-2));
    }
}
