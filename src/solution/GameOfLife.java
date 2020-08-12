package solution;


/**
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * @author tianming
 */
public class GameOfLife {
    public static void main(String[] args) {

    }

    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] copyBoard = new int[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int aroundLive = 0;
                //寻找周围存活的细胞
                if ((i - 1) >= 0 && (j-1) >=0) {
                    if (copyBoard[i-1][j-1] == 1){
                        aroundLive++;
                    }
                }
                if ((i - 1) >= 0){
                    if (copyBoard[i-1][j] == 1){
                        aroundLive++;
                    }
                }
                if ((i - 1) >= 0 && (j+1)<col){
                    if (copyBoard[i-1][j+1] == 1){
                        aroundLive++;
                    }
                }
                //寻找周围存活的细胞
                if ((j-1) >=0) {
                    if (copyBoard[i][j-1] == 1){
                        aroundLive++;
                    }
                }
                if ((j+1)<col){
                    if (copyBoard[i][j+1] == 1){
                        aroundLive++;
                    }
                }
                //寻找周围存活的细胞
                if ((i + 1) < row && (j-1) >=0) {
                    if (copyBoard[i+1][j-1] == 1){
                        aroundLive++;
                    }
                }
                if ((i + 1) < row){
                    if (copyBoard[i+1][j] == 1){
                        aroundLive++;
                    }
                }
                if ((i + 1) < row && (j+1)<col){
                    if (copyBoard[i+1][j+1] == 1){
                        aroundLive++;
                    }
                }
                int current = copyBoard[i][j];
                if (current == 1){
                    if (aroundLive <=3 && aroundLive>=2){
                        board[i][j] = 1;
                    }else {
                        board[i][j] = 0;
                    }
                }else {
                    if (aroundLive == 3){
                        board[i][j] = 1;
                    }
                }
            }
        }

    }
}
