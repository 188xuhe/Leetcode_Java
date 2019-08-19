package leetcode.Stack;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 *
 * 示例：
 * 1————————2
 * |        |
 * |        |
 * 4————————3
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class cloneGraph {
    private Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        return DFS(node);
    }

    public Node DFS(Node node){
        if (!map.containsKey(node)){
            Node copy = new Node(node.val, new LinkedList<>());
            map.put(node, copy);
            for (Node n : node.neighbors)
                copy.neighbors.add(DFS(n));
        }
        return map.get(node);

    }
}
