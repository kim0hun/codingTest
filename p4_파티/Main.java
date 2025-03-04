package p4_파티;

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.index, o.distance);
        }
    }

    static int[] dijkstra(int startNode, List<List<Node>> graph, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int distance[] = new int[n+1];
        Arrays.fill(distance, MAX_VALUE);
        distance[startNode] = 0;
        pq.offer(new Node(startNode, 0));

        while(!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentIndex = currentNode.index;
            int currentDistance = currentNode.distance;

            if (distance[currentIndex] < currentDistance) continue;

            for (Node neighbor : graph.get(currentIndex)) {
                int newDistance = currentDistance + neighbor.distance;
                
                if (newDistance < distance[neighbor.index]) {
                    distance[neighbor.index] = newDistance;
                    pq.offer(new Node(neighbor.index, newDistance));
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(startIndex).add(new Node(endIndex, distance));
            reverseGraph.get(endIndex).add(new Node(startIndex, distance));
        }

        int[] distanceFromX = dijkstra(x, graph, n);

        int[] distanceToX = dijkstra(x, reverseGraph, n);

        int maxTime = 0;
        for (int i= 1;i<=n;i++) {
            maxTime = Math.max(maxTime, distanceFromX[i] + distanceToX[i]);
        }

        System.out.println(maxTime);

        br.close();
    }
}