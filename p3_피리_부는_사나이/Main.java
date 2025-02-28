package p3_피리_부는_사나이;

import java.util.*;
import java.io.*;

public class Main {

    static char[][] map;
    static int row, col;
    static int[][] visited;
    static int count = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> dirMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        visited = new int[row][col];

        dirMap.put('U', 0);
        dirMap.put('D', 1);
        dirMap.put('L', 2);
        dirMap.put('R', 3);

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);

        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = 1;

        int d = dirMap.get(map[x][y]);
        int nextX = x + dx[d];
        int nextY = y + dy[d];

        if (!(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col)) {
            count++;
        } else if (visited[nextX][nextY] == 1) {
            count++;
        } else if (visited[nextX][nextY] == 0) {
            dfs(nextX, nextY);
        }

        visited[x][y] = 2;
    }
}