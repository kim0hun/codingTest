import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        long[] result = new long[testCase];

        for (int i = 0; i < testCase; i++) {
            int buildingNum = sc.nextInt();
            int ruleNum = sc.nextInt();
            int[] buildingTime = new int[buildingNum + 1];
            for (int j = 1; j <= buildingNum; j++) {
                buildingTime[j] = sc.nextInt();
            }

            Map<Integer, List<Integer>> reverseMap = new HashMap<>();
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int k = 0; k < ruleNum; k++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(value);
                reverseMap.putIfAbsent(value, new ArrayList<>());
                reverseMap.get(value).add(key);
            }

            int destination = sc.nextInt();

            System.out.println(map);

            int tempNum = destination;
            long sum = 0;
            while (reverseMap.containsValue(tempNum)) {

                List<Integer> list = map.get(tempNum);

                int maxNum = 0;
                for (int t: list) {
                    if(maxNum <= buildingTime[t]){
                        tempNum = t;
                    }
                }
            }

            while (map.containsKey(tempNum)) {

                sum += buildingTime[tempNum];

                List<Integer> list = map.get(tempNum);

                int maxNum = 0;
                for (int t: list) {
                    if(maxNum <= buildingTime[t]){
                        maxNum = buildingTime[t];
                        tempNum = t;
                    }
                }

            }
            sum += buildingTime[tempNum];
            result[i] = sum;
            // System.out.println("sum: " + sum);
        }
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}