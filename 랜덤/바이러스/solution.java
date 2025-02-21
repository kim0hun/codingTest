import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computer_num = sc.nextInt();
        int network_num = sc.nextInt();
        int[] result = new int[computer_num + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= computer_num; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < network_num; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();

        result[1]++;
        for (int i : list.get(1)) {
            queue.add(i);
            result[i]++;
        }
        list.get(1).clear();

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i : list.get(temp)) {
                queue.add(i);
                result[i]++;
            }
            list.get(temp).clear();
        }
        int count = -1;
        for (int temp : result) {
            if (temp != 0) {
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}