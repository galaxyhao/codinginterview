package codinginterview;

public class Practice04 {
    public static void main(String[] args) {
        int a [][] = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(5,a));
    }

    private static boolean find(int target,int[][] array){
        boolean found = false;
        int i = 0;
        int j = array.length - 1;
        while ((j >= 0 && i < array[j].length)){
            if(array[i][j] > target){
                j--;
            }else if(array[i][j] < target) {
                i++;
            }else {
                found = true;
                break;
            }
        }
        return found;
    }
}
