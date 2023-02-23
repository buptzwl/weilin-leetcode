package hot100;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 先原地上下翻转
        for(int col=0;col<n;col++){
            for(int row=0;row<n/2;row++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[n-1-row][col];
                matrix[n-1-row][col] = temp;
            }
        }
        // 再转置？ 转置是什么意思
        for(int row = 0;row<n;row++){
            for(int col = row;col<n;col++){
                 // 这里用col=row 而不是row+1是为了防止越界 尽管这样对角线会进行一次无效操作
                 if(col == row) continue;
                 int temp = matrix[row][col];
                 matrix[row][col] = matrix[col][row];
                 matrix[col][row] = temp;

            }
        }
    }    
}
