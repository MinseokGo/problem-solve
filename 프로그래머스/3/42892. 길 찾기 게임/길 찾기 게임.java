import java.util.*;

class Solution {
    
    private static final List<Node> nodes = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfos) {
        for (int i = 0; i < nodeinfos.length; i++) {
            nodes.add(new Node(i + 1, nodeinfos[i][0],  nodeinfos[i][1]));
        }
        
        Collections.sort(nodes, (n1, n2) -> {
            return n2.y - n1.y;
        });
        
        Node root = nodes.get(0);
        nodes.remove(0);
        
        for (Node node : nodes) {
            binaryTree(root, node);
        }
        List<Integer> preOrders = new ArrayList<>();
        preOrder(root, preOrders);
        int[] pre = preOrders.stream().
            mapToInt(Integer::intValue)
            .toArray();
        
        List<Integer> postOrders = new ArrayList<>();
        postOrder(root, postOrders);
        int[] post = postOrders.stream().
            mapToInt(Integer::intValue)
            .toArray();

        int[][] answer = new int[2][nodes.size() + 1];
        answer[0] = pre;
        answer[1] = post;
        
        return answer;
    }
    
    private void preOrder(Node root, List<Integer> orders) {
        orders.add(root.num);
        if (root.left != null) {
            preOrder(root.left, orders);
        }
        if (root.right != null) {
            preOrder(root.right, orders);
        }
    }
    
    private void postOrder(Node root, List<Integer> orders) {
        if (root.left != null) {
            postOrder(root.left, orders);
        }
        if (root.right != null) {
            postOrder(root.right, orders);
        }
        orders.add(root.num);
    }
    
    private void binaryTree(Node root, Node node) {
        while (true) {
            if (root.x > node.x) {
                if (root.left == null) {
                    root.left = node;
                    return;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = node;
                    return;
                } else {
                    root = root.right;
                }
            }
        }
    }
    
    static class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "Node" + num + "(" + x + ", " + y + ")";
        }
    }
}