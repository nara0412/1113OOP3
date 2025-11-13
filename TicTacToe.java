public class TicTacToe {
    private char[][] board;
    private int moves;

    public TicTacToe() {
        board = new char[3][3];
        moves = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // 設定位置
    public boolean set(int row, int col, char player) {
        if (player != 'X' && player != 'O') {
            throw new IllegalArgumentException("Player must be X or O");
        }
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Position out of range");
        }
        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = player;
        moves++;
        return true;
    }

    // 遊戲狀態
    public String evaluate() {
        // 橫線
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return String.valueOf(board[i][0]);
            }
        }

        // 直線
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return String.valueOf(board[0][i]);
            }
        }

        // 斜線
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return String.valueOf(board[0][0]);
        }

        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return String.valueOf(board[0][2]);
        }

        // 和局
        if (moves == 9) {
            return "Tie";
        }

        // 尚未結束
        return "Continue";
    }

    public char[][] getBoard() {
        return board;
    }
}
