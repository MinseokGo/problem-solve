import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        ArrayList<Node>[] nodes = new ArrayList[N + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length; i++) {
            nodes[road[i][0]].add(new Node(road[i][1], road[i][2]));
            nodes[road[i][1]].add(new Node(road[i][0], road[i][2]));
        }
        distance[1] = 0;
        
        dijkstra(nodes, distance);
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        } 
        
        return answer;
    }
    
    private void dijkstra(ArrayList<Node>[] nodes, int[] distance) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (distance[node.vertex] < node.weight) {
                continue;
            }
            
            for (int i = 0; i < nodes[node.vertex].size(); i++) {
                int vertex = nodes[node.vertex].get(i).vertex;
                int weight = nodes[node.vertex].get(i).weight + node.weight;
                if (distance[vertex] > weight) {
                    distance[vertex] = weight;
                    queue.add(new Node(vertex, weight));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        
        int vertex;
        int weight;
        
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node other) {
            return weight - other.weight;
        }
    }
}