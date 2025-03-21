package p7_스도쿠;

import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static boolean solved = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        solve(0, 0);
        sc.close();
    }

    // 백트래킹을 활용한 스도쿠 풀이
    public static void solve(int row, int col) {
        if (row == 9) { // 스도쿠를 완성한 경우 출력
            printBoard();
            solved = true;
            return;
        }

        if (board[row][col] == 0) { // 빈칸인 경우
            for (int num = 1; num <= 9; num++) {
                if (isValid(row, col, num)) {
                    board[row][col] = num;
                    solve(col == 8 ? row + 1 : row, (col + 1) % 9);
                    if (solved) return; // 한 가지 정답만 출력
                    board[row][col] = 0; // 백트래킹
                }
            }
        } else { // 이미 숫자가 채워진 경우 다음 칸으로 이동
            solve(col == 8 ? row + 1 : row, (col + 1) % 9);
        }
    }

    // 스도쿠 규칙을 만족하는지 확인
    public static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false; // 행 또는 열 중복 체크
        }

        int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false; // 3×3 박스 중복 체크
            }
        }

        return true;
    }

    // 스도쿠 출력
    public static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
