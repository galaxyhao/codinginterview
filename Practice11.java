package codinginterview;

/**
 * 旋转数组的最小数字
 */
public class Practice11 {
    private static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if(length <=0){
            return 0;
        }

        int start = 0;
        int end = length-1;
        int middle = 0;
        while (array[end]<=array[start]){
            if(end-start ==1){
                middle = end;
                break;
            }

            middle = (start+end)/2;

            if(array[middle]==array[start] && array[middle]==array[end]) return minInOrder(array,start,end);
            if(array[middle]>=array[start]){  //若中间元素大于开始元素，说明最小元素在中间元素后面
                start = middle;
            }else if(array[middle]<=array[end]){
                end = middle;
            }
        }
        return array[middle];
    }

    private static int minInOrder(int [] array,int start,int end){
        int result = array[start];
        for (int i =start+1;i<=end;i++){
            if(result > array[i])
                result = array[i];
        }
        return result;
    }

    private static int test01(){
        int [] arr = {2,3,4,5,1};
        return minNumberInRotateArray(arr);
    }
    private static int test02(){
        int [] arr = {1,0,1,1,1};
        return minNumberInRotateArray(arr);
    }

    public static void main(String[] args) {
        System.out.println(test01());
        System.out.println(test02());
    }
}
