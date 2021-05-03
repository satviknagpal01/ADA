import java.util.Scanner;

public class queen {  
    private void print(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.printf(" %d", board[i][j]);
            }
            System.out.println();
        }
    }

    private boolean isValid(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0 ; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }

    public boolean enumerate(int[][] board, int col) {
        if (col == board.length) return true;
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 1;
                if (enumerate(board, col+1)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args){
        queen q = new queen();
		int n ;
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
        int[][] board = new int[n][n];
        if (!q.enumerate(board, 0)) {
            System.out.println("not found");
        }
        q.print(board);
    }
}