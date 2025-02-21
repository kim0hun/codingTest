package P1_말이_되고픈_원숭이;

import java.util.*;

public class Main {

    static int W, H, K;
    static int[][] board;
    static int[] monkeyDx = { -1, 0, 1, 0 };
    static int[] monkeyDy = { 0, 1, 0, -1 };
    static int[] horseDx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] horseDy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static boolean[][][] visited;  // 3차원 방문 배열 (x, y, 남은 말 이동 횟수)

    static class State {
        int x, y, level, horseMovesLeft;
        State(int x, int y, int level, int horseMovesLeft) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.horseMovesLeft = horseMovesLeft;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        board = new int[H][W];
        visited = new boolean[H][W][K + 1];  // (x, y)에서 남은 말 이동 횟수에 따라 방문 여부 체크

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(bfs());
        sc.close();
    }

    static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            // 도착 지점에 도달하면 최단 거리 반환
            if (cur.x == H - 1 && cur.y == W - 1) {
                return cur.level;
            }

            // 원숭이 이동 (상, 하, 좌, 우)
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + monkeyDx[i];
                int ny = cur.y + monkeyDy[i];

                if (isValid(nx, ny) && !visited[nx][ny][cur.horseMovesLeft]) {
                    visited[nx][ny][cur.horseMovesLeft] = true;
                    queue.add(new State(nx, ny, cur.level + 1, cur.horseMovesLeft));
                }
            }

            // 말 이동 (K번 가능)
            if (cur.horseMovesLeft > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + horseDx[i];
                    int ny = cur.y + horseDy[i];

                    if (isValid(nx, ny) && !visited[nx][ny][cur.horseMovesLeft - 1]) {
                        visited[nx][ny][cur.horseMovesLeft - 1] = true;
                        queue.add(new State(nx, ny, cur.level + 1, cur.horseMovesLeft - 1));
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W && board[x][y] == 0;
    }
}
