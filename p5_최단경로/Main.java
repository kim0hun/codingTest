package p5_최단경로;

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

    static int[] dijkstra(List<List<Node>> graph, int startIndex, int nodeNum) {
        int[] distance = new int[nodeNum + 1];
        Arrays.fill(distance, MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[startIndex] = 0;
        pq.offer(new Node(startIndex, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentIndex = node.index;
            int currentDistance = node.distance;

            for (Node neighborNode : graph.get(currentIndex)) {
                int newDistance = currentDistance + neighborNode.distance;

                if (newDistance < distance[neighborNode.index]) {
                    distance[neighborNode.index] = newDistance;
                    pq.offer(new Node(neighborNode.index, newDistance));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        int distance[] = dijkstra(graph, K, V);

        for (int i = 1; i <= V; i++) {
            if (distance[i] == MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

        br.close();
    }
}