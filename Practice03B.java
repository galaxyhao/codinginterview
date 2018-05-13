package codinginterview;

/**
 * 不修改数组找出重复的数字
 */
public class Practice03B {
    private boolean duplicate(int numbers[], int length, int[] duplication) {
        int start = 1;
        int end = length-1;

        while (end >= start){
            int middle = (start+end)/2;
            int count = countSum(numbers,length,start,middle);

            if(start == end){
                if(count > 1){
                    duplication[0] = start;
                    return true;
                }else {
                    break;
                }
            }
            if(count>middle-start+1){
                end = middle;
            }else {
                start = middle+1;
            }

        }
        return false;
    }
    private int countSum(int numbers[],int length, int start, int end){
        int count = 0;

        for(int i=0;i<length;i++){
            if(numbers[i]>=start && numbers[i]<=end){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] numbers = {2,3,5,4,3,2,6,7};
        int [] duplication = new int[1];

        Practice03B practice03B = new Practice03B();
        practice03B.duplicate(numbers,8,duplication);

        System.out.println(duplication[0]);
    }
}
