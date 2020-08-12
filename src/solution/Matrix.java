package solution; /**
 * https://leetcode-cn.com/problems/01-matrix/
 */

/**
 * @author tianming
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        new Matrix().updateMatrix(matrix);
    }

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] distance = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = -1;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.distance(matrix, distance, i, j);
            }
        }
        return distance;
    }

    public int distance(int[][] matrix, int[][] distance, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        if ((i < 0 || i >= row) || (j < 0 || j >= col)) {
            return Integer.MAX_VALUE;
        }
        if (distance[i][j] != -1) {
            return distance[i][j];
        }
        if (matrix[i][j] == 0) {
            distance[i][j] = 0;
            return 0;
        }

        if ((j - 1 >= 0 && matrix[i][j - 1] == 0)
                || (j + 1 < col && matrix[i][j + 1] == 0)
                || (i - 1 >= 0 && matrix[i - 1][j] == 0)
                || (i + 1 < row && matrix[i + 1][j] == 0)) {
            distance[i][j] = 1;
            return 1;
        }
        int min = Math.min(
                Math.min(distance(matrix, distance, i, j - 1), distance(matrix, distance, i, j + 1)),
                Math.min(distance(matrix, distance, i - 1, j), distance(matrix, distance, i + 1, j))
        ) + 1;
        distance[i][j] = min;
        return min;
    }
}
