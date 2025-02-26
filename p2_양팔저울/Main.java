package p2_양팔저울;

import java.util.*;

public class Main {
    private static int MAX_WEIGHT = 40001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weightNum = sc.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] weightCase = new boolean[MAX_WEIGHT];

        deque.addLast(0);

        for (int i = 0; i < weightNum; i++) {
            int weight = sc.nextInt();

            int dequeLength = deque.size();
            for (int j = 0; j < dequeLength; j++) {
                int temp = deque.pollFirst();
                deque.addLast(temp);
                deque.addLast(temp + weight);
                deque.addLast(temp - weight);
            }
            deque = new ArrayDeque<>(new LinkedHashSet<>(deque));
        }

        for (Integer temp : deque) {
            if (temp >= 0 && temp < MAX_WEIGHT) {
                weightCase[temp] = true;
            }
        }

        int ballNum = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ballNum; i++) {
            int ball = sc.nextInt();

            if (weightCase[ball]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
