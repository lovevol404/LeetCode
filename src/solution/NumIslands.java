package solution;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author tianming
 */
public class NumIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        char ONE = '1';
        char ZERO = '0';
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (col == 0) {
            return 0;
        }
        int numIslands = 0;
        Queue<Pair<Integer, Integer>> pairQueue = new LinkedList<>();
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == ZERO){
                    continue;
                }
                numIslands++;
                pairQueue.add(new Pair<>(i, j));
                while (!pairQueue.isEmpty()){
                    Pair<Integer, Integer> pair = pairQueue.poll();
                    int m = pair.getKey();
                    int n = pair.getValue();
                    grid[m][n]=ZERO;
                    if (m - 1 >= 0 && grid[m-1][n] == ONE){
                        pairQueue.add(new Pair<>(m-1, n));
                        grid[m-1][n] = ZERO;
                    }
                    if (m + 1 < row && grid[m+1][n] == ONE){
                        pairQueue.add(new Pair<>(m+1, n));
                        grid[m+1][n] = ZERO;
                    }
                    if (n - 1 >= 0 && grid[m][n-1] == ONE){
                        pairQueue.add(new Pair<>(m, n-1));
                        grid[m][n-1] = ZERO;
                    }
                    if (n + 1 < col && grid[m][n+1] == ONE){
                        pairQueue.add(new Pair<>(m, n+1));
                        grid[m][n+1] = ZERO;
                    }
                }
            }
        }
        return numIslands;
    }
}
