package codinginterview;

/**
 * 矩阵中的路径
 */
public class Practice12 {
    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int strLocal = 0; //标识下一个进行寻找的字符在字符数组中的位置
        boolean hasPath;

        boolean [][] visited = new boolean[rows][cols];   //定义一个布尔矩阵标记指定位置是否被访问过
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                hasPath = pathCore(matrix,rows,cols,i,j,str,strLocal,visited);
                if (hasPath){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean pathCore(char[] matrix,int rows,int cols,int row,int col,char[] str,int strLocal,boolean[][] visited){
        boolean hasPath = false;

        if (str.length == strLocal){
            return true;
        }
        if (row>=0 && row<rows && col>=0 && col<cols && str[strLocal]==matrix[row*cols+col] && !visited[row][col]){
            visited[row][col] = true;
            ++strLocal;

            hasPath = pathCore(matrix,rows,cols,row-1,col,str,strLocal,visited)
                || pathCore(matrix,rows,cols,row+1,col,str,strLocal,visited)
                || pathCore(matrix,rows,cols,row,col-1,str,strLocal,visited)
                || pathCore(matrix,rows,cols,row,col+1,str,strLocal,visited);

            if (!hasPath){
                --strLocal;
                visited[row][col] = false;
            }
        }
        return  hasPath;
    }

    public static void main(String[] args) {
        char [] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char [] str = {'A','B','C','C','E','D'};
        boolean result = hasPath(matrix,3,4,str);
        System.out.println(result);
    }
}
