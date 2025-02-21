// import java.util.ArrayDeque;
// import java.util.Arrays;
// import java.util.Deque;
// import java.util.Scanner;

// public class main {

//     static int W;
//     static int H;
//     static int[][] board;
//     static int[] monkeyDx = { -1, 0, 1, 0 };
//     static int[] monkeyDy = { 0, 1, 0, 1 };
//     static int[] horseDx = { -2, -1, 1, 2, 2, 1, -1, -2 };
//     static int[] horseDy = { 1, 2, 2, 1, -1, -2, -2, -1 };
//     static int[][] visited;

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int K = sc.nextInt();

//         W = sc.nextInt();
//         H = sc.nextInt();

//         board = new int[H][W];
//         visited = new int[H][W];

//         for (int i = 0; i < H; i++) {
//             for (int j = 0; j < W; j++) {
//                 board[i][j] = sc.nextInt();
//             }
//         }

//         int result = -1;

//         Deque<Integer[]> deq = new ArrayDeque<>();
//         deq.addLast(new Integer[] { 0, 0, 0, K }); // x, y, level, horse
//         visited[0][0] = 3;

//         while (!deq.isEmpty()) {

//             Integer[] temp = deq.pollFirst();
//             System.out.println(Arrays.toString(temp));

//             if(temp[0] == H-1 && temp[1] == W-1) {
//                 if(result == -1){
//                     result = temp[2];
//                 } else if(result > temp[2]){
//                     result = temp[2];
//                 }
//             }else{

//                 for (int i = 0; i < 4; i++) {
//                     int nextX = temp[0] + monkeyDx[i];
//                     int nextY = temp[1] + monkeyDy[i];

//                     if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && board[nextX][nextY] == 0
//                             && (visited[nextX][nextY] == 0 || visited[nextX][nextY] == 2)) {
//                         deq.addLast(new Integer[] { nextX, nextY, temp[2] + 1, temp[3] });
//                         visited[nextX][nextY] += 1;
//                     }
//                 }

//                 if (temp[3] > 0) {
//                     for (int i = 0; i < 8; i++) {
//                         int nextX = temp[0] + horseDx[i];
//                         int nextY = temp[1] + horseDy[i];

//                         if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && board[nextX][nextY] == 0
//                                 && (visited[nextX][nextY] == 0 || visited[nextX][nextY] == 1)) {
//                             deq.addLast(new Integer[] { nextX, nextY, temp[2] + 1, temp[3] - 1 });
//                             visited[nextX][nextY] += 2;
//                         }
//                     }
//                 }

//             }

//         }

//         System.out.println(result);

//         sc.close();
//     }
// }

    import java.util.ArrayDeque;
    import java.util.Arrays;
    import java.util.Deque;
    import java.util.Scanner;

    public class main {

        static int W;
        static int H;
        static int[][] board;
        static int[] monkeyDx = { -1, 0, 1, 0 };
        static int[] monkeyDy = { 0, 1, 0, 1 };
        static int[] horseDx = { -2, -1, 1, 2, 2, 1, -1, -2 };
        static int[] horseDy = { 1, 2, 2, 1, -1, -2, -2, -1 };
        static int[][] visited;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int K = sc.nextInt();

            W = sc.nextInt();
            H = sc.nextInt();

            board = new int[H][W];
            visited = new int[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            int result = -1;

            Deque<Object[]> deq = new ArrayDeque<>();
            visited[0][0] = 1;
            deq.addLast(new Object[] { 0, 0, 0, K, visited }); // x, y, level, horse

            while (!deq.isEmpty()) {

                Object[] temp = deq.pollFirst();
                Integer x = (Integer) temp[0];
                Integer y = (Integer) temp[1];
                Integer level = (Integer) temp[2];
                Integer horseCount = (Integer) temp[3];
                int[][] tempVisited = (int[][]) temp[4];

                if (x == H - 1 && y == W - 1) {
                    if (result == -1) {
                        result = level;
                    } else if (result > level) {
                        result = level;
                    }
                } else {

                    for (int i = 0; i < 4; i++) {
                        int nextX = x + monkeyDx[i];
                        int nextY = y + monkeyDy[i];

                        if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && board[nextX][nextY] == 0
                                && tempVisited[nextX][nextY] == 0) {
                            int[][] deepCopy = Arrays.stream(tempVisited)
                                    .map(row -> Arrays.copyOf(row, row.length))
                                    .toArray(int[][]::new);

                            deepCopy[nextX][nextY] = 1;
                            deq.addLast(new Object[] { nextX, nextY, level + 1, horseCount, deepCopy });
                        }
                    }

                    if (horseCount > 0) {
                        for (int i = 0; i < 8; i++) {
                            int nextX = x + horseDx[i];
                            int nextY = y + horseDy[i];

                            if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && board[nextX][nextY] == 0
                                    && tempVisited[nextX][nextY] == 0) {

                                int[][] deepCopy = Arrays.stream(tempVisited)
                                        .map(row -> Arrays.copyOf(row, row.length))
                                        .toArray(int[][]::new);

                                deepCopy[nextX][nextY] = 1;
                                deq.addLast(new Object[] { nextX, nextY, level + 1, horseCount - 1, deepCopy });

                            }
                        }
                    }

                }

            }

            System.out.println(result);

            sc.close();
        }
    }