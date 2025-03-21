package p6_이모티콘;

import java.util.*;

public class Main {
    static class State {
        int screen, clipboard, time;
        
        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static int bfs(int S) {
        boolean[][] visited = new boolean[2001][2001];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(1, 0, 0));
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.screen == S) return cur.time;

            if (!visited[cur.screen][cur.screen]) {
                queue.add(new State(cur.screen, cur.screen, cur.time + 1));
                visited[cur.screen][cur.screen] = true;
            }

            if (cur.clipboard > 0 && cur.screen + cur.clipboard < 2000 && !visited[cur.screen + cur.clipboard][cur.clipboard]) {
                queue.add(new State(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
                visited[cur.screen + cur.clipboard][cur.clipboard] = true;
            }

            if (cur.screen > 0 && !visited[cur.screen - 1][cur.clipboard]) {
                queue.add(new State(cur.screen - 1, cur.clipboard, cur.time + 1));
                visited[cur.screen - 1][cur.clipboard] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        System.out.println(bfs(S));
        sc.close();
    }
}
