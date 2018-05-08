package codinginterview;

import unit.Unit;

/**
 * 数组中重复的数字
 */
public class Practice03 {
    /**
     * 通过哈希表的辅助 时间复杂度O(n),空间复杂度O(n)
     *
     * @param arr 输入数组
     * @param n 数组长度
     * @return 重复数组或无重复数组标识
     */
    private int findRepeatNumber1(int [] arr, int n){
        int [] hashTable = new int[n];

        for (int i = 0; i < n; i++) {
            if(hashTable[arr[i]] == 1){
                return arr[i];
            }
            hashTable[arr[i]] = 1;
        }
        return -1;
    }

    /**
     * 使用交换 时间复杂度O(n),空间复杂度O(1)
     *
     * @param arr 输入数组
     * @param n 数组长度
     * @return
     */
    private int findRepeatNumber2(int [] arr,int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] != i){
                if(arr[arr[i]] == arr[i]){
                    return arr[i];
                }else {
                    Unit.swap(arr,i,arr[i]);
                }
            }
        }
        return -1;
    }
    private boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            if(numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    int temp = numbers[i];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr = {2,1,3,1,4};
        int [] duplication = new int[1];

        Practice03 practice03 = new Practice03();
        int repeatNumber1 = practice03.findRepeatNumber1(arr, arr.length);
        int repeatNumber2 = practice03.findRepeatNumber2(arr, arr.length);
        boolean duplicate = practice03.duplicate(arr, arr.length, duplication);
        System.out.println(repeatNumber1);
        System.out.println(repeatNumber2);
        System.out.println(duplicate);
        System.out.println(duplication[0]);
    }
}
