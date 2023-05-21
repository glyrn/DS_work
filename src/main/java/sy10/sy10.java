package sy10;

public class sy10 {

}
//import java.net.InterfaceAddress;
//        import java.util.*;
//
//        import org.jgrapht.Graph;
//        import org.jgrapht.Graphs;
//        import org.jgrapht.graph.DefaultEdge;
//        import org.jgrapht.graph.SimpleGraph;
//
//
////import sy05.BiTree;
////import sy05.BiTreeNode;
////import sy05.func_sy05;
////
////import java.util.List;
////
////public class Main {
////    public static void main(String[] args) {
////        BiTree T = new BiTree("AB##CD###");
////        List<BiTreeNode> path = T.getPath(T.getRoot(), T.getRoot().getRchild().getLchild());
////
////        System.out.println("路径为");
////        for (int i = path.size() - 1; i >= 0; i --){
////            System.out.print(path.get(i).data + " ");
////        }
////    }
////}
//        import org.jgrapht.Graph;
//        import org.jgrapht.Graphs;
//        import org.jgrapht.graph.DefaultEdge;
//        import org.jgrapht.graph.SimpleGraph;
//        import org.jgrapht.traverse.BreadthFirstIterator;
//        import org.jgrapht.traverse.DepthFirstIterator;
//        import sy10.IGraph;
//
//        import org.jgrapht.Graph;
//        import org.jgrapht.alg.connectivity.ConnectivityInspector;
//        import org.jgrapht.graph.DefaultEdge;
//        import org.jgrapht.graph.SimpleGraph;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        // 创建一个简单图形
//        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
//
//        // 添加顶点
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//
//        // 添加边
//        graph.addEdge("A", "B");
//        graph.addEdge("B", "C");
//        graph.addEdge("C", "D");
//        graph.addEdge("D", "E");
//
//        // 使用 BFS 进行遍历
//        BreadthFirstIterator<String, DefaultEdge> bfsIterator =
//                new BreadthFirstIterator<>(graph, "A");
//        System.out.println("BFS 遍历结果:");
//        while (bfsIterator.hasNext()) {
//            String vertex = bfsIterator.next();
//            System.out.println(vertex);
//        }
//
//        // 使用 DFS 进行遍历
//        DepthFirstIterator<String, DefaultEdge> dfsIterator =
//                new DepthFirstIterator<>(graph, "A");
//        System.out.println("DFS 遍历结果:");
//        while (dfsIterator.hasNext()) {
//            String vertex = dfsIterator.next();
//            System.out.println(vertex);
//        }
//
//        // 获取连通分量
//        List<Set<String>> connectedComponents = getConnectedComponents(graph);
//
//        // 打印每个连通分量
//        System.out.println("连通分量:");
//        for (Set<String> component : connectedComponents) {
//            System.out.println(component);
//        }
//    }
//
//    public static <V, E> List<Set<V>> getConnectedComponents(Graph<V, E> graph) {
//        ConnectivityInspector<V, E> connectivityInspector = new ConnectivityInspector<>(graph);
//        return connectivityInspector.connectedSets();
//    }
//
//
//
////    public static void CC_BFS(Graph G) throws Exception{
////        boolean[] visited = new boolean[G.getVexNum()];
////        for (int v = 0; v < G.getVexNum(); v ++) {
////            visited[v] = false;
////        }
////        Queue Q = new LinkedList();
////        Queue P = new LinkedList();
////        int i = 0; // 记录连通分支数
////        for (int v = 0; v < G.getVexNum(); v ++) {
////            P.clear();
////            if (!visited[v]) {
////                visited[v] = true;
////                P.offer(G.getVex(v));
////                Q.offer(v);
////                while (!Q.isEmpty()) {
////                    int u = (Integer) Q.poll();
////                    for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)) {
////                        if (!visited[w]) {
////                            visited[w] = true;
////                            P.offer(G.getVex(w));
////                            Q.offer(w);
////                        }
////                    }
////                }
////                System.out.println("图的第" + ++i + "个连通分量为 ");
////                while (!P.isEmpty()) {
////                    System.out.print(P.poll().toString() + " ");
////                }
////                System.out.println();
////            }
////        }
////
////    }
//
//
//
//}
////class Solution {
////    public int totalFruit(int[] fruits) {
////        int n = fruits.length;
////
////        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
////        int left = 0;
////        int ans = 0;
////        for (int right = 0; right < n; right ++) {
////            cnt.put(fruits[right], (cnt.getOrDefault(fruits[right], 0) + 1));
////            while (cnt.size() > 2) {
////                cnt.put(fruits[left], cnt.get(fruits[left] - 1));
////                if (cnt.get(fruits[left] == 0)) {
////                    cnt.remove(fruits[left]);
////                }
////                ++ left;
////            }
////            ans = Math.max(ans, right - left + 1);
////        }
////        return ans;
////    }
////}
