import java.util.Arrays;
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int MOD = 1000000000;

        int[] currArr = new int[] { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int[] nextArr = new int[10];

        for (int i = 1; i < n; i++) {
            Arrays.fill(nextArr, 0);

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    nextArr[j] = currArr[j + 1] % MOD;
                } else if (j == 9) {
                    nextArr[j] = currArr[j - 1] % MOD;
                } else {
                    nextArr[j] = (currArr[j - 1] + currArr[j + 1]) % MOD;
                }
            }
            System.arraycopy(nextArr, 0, currArr, 0, 10);
        }

        int count = 0;
        for (int temp : currArr) {
            count += temp;
            count %= MOD;
        }

        System.out.println(count);
    }
}
