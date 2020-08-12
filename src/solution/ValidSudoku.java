package solution;/*solution.ValidSudoku.java
Copyright 2011-2020 Qunhe Tech, all rights reserved.
Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.

@Author: tianming
@created: 2020/4/2
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author tianming
 */
public class ValidSudoku {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
        };

        char[][] input2 = new char[][]{
                {'6', '.', '.', '7', '3', '.', '.', '9', '.'},
                {'9', '.', '.', '.', '.', '8', '.', '.', '.'},
                {'.', '5', '.', '.', '.', '.', '3', '.', '4'},
                {'.', '.', '.', '4', '7', '.', '.', '5', '.'},
                {'.', '7', '5', '3', '.', '.', '.', '.', '8'},
                {'.', '.', '9', '.', '2', '.', '7', '6', '.'},
                {'.', '2', '8', '.', '4', '3', '1', '7', '.'},
                {'.', '.', '1', '.', '.', '6', '.', '.', '5'},
                {'3', '.', '.', '.', '1', '.', '.', '4', '.'}};
        System.out.println(new ValidSudoku().isValidSudoku(input2));
    }

    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        Set<Character> characters = new HashSet<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        while (true){
            insert:
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] != '.'){
                        continue;
                    }
                    Set<Character> rowSet = new HashSet<>();
                    for (int k = 0; k < col; k ++){
                        char c = board[i][k];
                        if (c != '.' && rowSet.contains(c)){
                            return false;
                        }
                        if (c != '.'){
                            rowSet.add(c);
                        }
                    }
                    Set<Character> colSet = new HashSet<>();
                    for (int k = 0; k < row; k ++){
                        char c = board[k][j];
                        if (c != '.' && colSet.contains(c)){
                            return false;
                        }
                        if (c != '.'){
                            colSet.add(c);
                        }
                    }
                    Set<Character> roundSet = new HashSet<>();
                    int rowStart = 0, rowEnd = 0;
                    int colStart = 0, colEnd = 0;
                    if (i>=0 && i <=2){
                        rowStart =0;
                        rowEnd = 2;
                    }
                    if (i>=3 && i <=5){
                        rowStart =3;
                        rowEnd = 5;
                    }
                    if (i>=6 && i <=8){
                        rowStart =6;
                        rowEnd = 8;
                    }
                    if (j>=0 && j <=2){
                        colStart=0;
                        colEnd=2;
                    }
                    if (j>=3 && j <=5){
                        colStart=3;
                        colEnd=5;
                    }
                    if (j>=6 && j <=8){
                        colStart=6;
                        colEnd=8;
                    }
                    for (int m = rowStart; m <= rowEnd; m++){
                        for (int n = colStart; n <= colEnd; n++){
                            char c = board[m][n];
                            if (c != '.' && roundSet.contains(c)){
                                return false;
                            }
                            if (c != '.'){
                                roundSet.add(c);
                            }
                        }
                    }
                    Set<Character> cs = new HashSet<>(characters);
                    cs.removeAll(rowSet);
                    cs.removeAll(colSet);
                    cs.removeAll(roundSet);
                    if (cs.size() == 1){
                        board[i][j] = (char)characters.toArray()[0];
                        break insert;
                    }else if (cs.size() == 0){
                        return false;
                    }
                }
            }
            if (done(board)){
                for (int i = 0; i < row; i++) {
                    System.out.println();
                    for (int j = 0; j < col; j++) {
                        System.out.print(board[i][j]);
                        System.out.print(" ");
                    }
                }
                return true;
            }else {
                return false;
            }
        }
    }

    public boolean done(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean done = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.'){
                    done = false;
                }
            }
        }
        return done;
    }
}
