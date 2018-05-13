package codinginterview;

/**
 *青蛙跳台阶
 */
public class Practice10B {
    int jumpFloor(int number) {
        if(number==0){
            return 0;
        }
        if (number==1){
            return 1;
        }
        if (number==2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int num = 0;
        for (int i=3;i<=number;i++){
            num = first + second;
            first = second;
            second = num;
        }
        return num;
    }
}
