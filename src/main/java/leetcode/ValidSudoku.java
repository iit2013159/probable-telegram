package leetcode;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] b = new char[][]{
                new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        //System.out.println(isValidSudoku(b));

        char[][] chars = new char[][]{
                new char[]{'8','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'}
        };
 
        System.out.println(isValidSudoku(chars));

    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != board[0].length || board.length < 3) {
            return false;
        }
        int xor, count;
        //boolean[] rowComp = new boolean[board.length];
        for (int i = 0; i < board.length; i++) {
            xor = 0;
            count = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] > '9') {
                    return false;
                }
                if (board[i][j] != '.') {
                    count++;
                    if (count == 1) {
                        xor = board[i][j];
                    } else {
                        xor ^= board[i][j];
                    }
                    if (count != 0 && xor == 0) {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            xor = 0;
            count = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (board[i][j] > '9') {
                    return false;
                }
                if (board[i][j] != '.') {
                    count++;
                    if (count == 1) {
                        xor = board[i][j];
                    } else {
                        xor ^= board[i][j];
                    }
                    if (count != 0 && xor == 0) {
                        return false;
                    }
                }
            }
        }

        for (int l = 0; l < board.length; l = l + 3) {
            for (int r = 0; r < board[0].length; r = r + 3) {
                xor = 0;
                count = 0;

                for (int i = l; i < l + 3; i++) {
                    for (int j = r; j < r + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        if (board[i][j] != '.') {
                            count++;
                            if (count == 1) {
                                xor = board[i][j];
                            } else {
                                xor ^= board[i][j];
                            }
                            if (count != 0 && xor == 0) {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;


    }

}
