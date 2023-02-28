package hot100;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // 这题还是回溯
        // 但是有了一个额外的二维数组由于标记是否走过这段路
        int rows = board.length;
        int cols = board[0].length;
        int row = 0;
        int col = 0;
        int index= 0;
        boolean[][] exist = new boolean[rows][cols];
        // return dfs(row,col,rows,cols,index,board,exist,word);
        // 这样做只是以0，0开头的
        // 所以必须要加双层的for循环
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i,j,rows,cols,index,board,exist,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int row,int col,int rows,int cols,int index,char[][] board,boolean[][] exist,String word){
      // 递归终止条件
      // 说明遍历完了
        if(index == word.length()){
            return true;
        }
        // 快速失败
        if(row<0||row>=rows||col<0||col>=cols||exist[row][col]||board[row][col]!=word.charAt(index)){
            return false;
        }
        // 递归过程
        exist[row][col] = true;// 第index位置没有问题
        index++;// 看第index+1个位置有没有问题
        boolean res = dfs(row+1,col,rows,cols,index,board,exist,word)||
        dfs(row-1,col,rows,cols,index,board,exist,word)||
        dfs(row,col+1,rows,cols,index,board,exist,word)||
        dfs(row,col-1,rows,cols,index,board,exist,word);
        if(!res){
            // index+1个位置有问题,都找不到路
            // index 也不能访问，所以index当前位置要设置为未访问
            // 没有找到则要回溯
            // 找到了就不用管
            exist[row][col] = false;
            index--;
        }
        return res;
        }
    }
    
