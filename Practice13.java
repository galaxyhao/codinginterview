package codinginterview;

/**
 * 机器人的运动范围
 *
 * 题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标
 * 的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Practice13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean visited [][] = new boolean [rows][cols];
        int count = move(rows, cols, 0, 0, threshold, visited);
        return count;
    }
    private int move(int rows,int cols,int row,int col,int threshold,boolean [][] visited){
        int count = 0;
        if (check(rows,cols,row,col,threshold,visited)){
            visited[row][col] = true;
            count = 1+move(rows,cols,row-1,col,threshold,visited)
                + move(rows,cols,row+1,col,threshold,visited)
                + move(rows,cols,row,col-1,threshold,visited)
                + move(rows,cols,row,col+1,threshold,visited);
        }
        return count;
    }
    private boolean check(int rows,int cols,int row,int col,int threshold,boolean [][] visited){
        int sum = getDigitSum(row)+getDigitSum(col);

        if(row>=0 && row<rows && col>=0 && col<cols && sum<=threshold && !visited[row][col]){
            return true;
        }else {
            return false;
        }
    }
    private int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Practice13 practice13 = new Practice13();
        int count = practice13.movingCount(2, 40, 40);
        System.out.println(count);
    }
}
