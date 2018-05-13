package codinginterview;

/**
 * 变态跳台阶
 */
public class Practice10C {
    public static int jumpFloorII(int target) {
        int [] n = new int[target+1];

        if (target==0) return 0;
        if (target==1) return 1;

        n[0] = 0;
        n[1] = 1;

        for (int i=2;i<=target;i++){
            for (int j=0;j<i;j++){
                n[i] += n[j];
            }
            n[i] += 1;
        }

        return n[target];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(6));
    }
}
