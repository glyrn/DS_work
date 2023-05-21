//package sy10;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
///*
//    邻接矩阵类
// */
//public class MGraph implements IGraph{
//    public final static int INFINITY = Integer.MAX_VALUE;
//    private GraphKind kind;
//    private int vexNum, arcNum;    //顶点数 边数
//    private Object[] vexs;//顶点
//    private int[][] arcs; //邻接矩阵
//    public MGraph () {
//        this.kind = null;
//        this.vexNum = 0;
//        this.arcNum = 0;
//        this.arcs = null;
//        this.vexs = null;
//    }
//    public MGraph(GraphKind kind, int vexNum, int arcNum, Object[] vexs, int[][]arcs) {
//        this.kind = kind;
//        this.vexNum = vexNum;
//        this.arcNum = arcNum;
//        this.vexs = vexs;
//        this.arcs = arcs;
//    }
//
//    public enum GraphKind {
//        UDG,
//        DG,
//        UDN,
//        DN
//    }
//    //创建图
//    @Override
//    public void createGraph () {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入图的类型");
//        GraphKind kind = GraphKind.valueOf(scanner.next());
//        switch (kind) {
//            case UDG:
//                createUDG();
//                return;
//            case DG:
//                createDG();
//                return;
//            case UDN:
//                createUDN();
//                return;
//            case DN:
//                createDN();
//                return;
//        }
//    }
//
//    //创建无向图
//    private void createUDG () {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请分别输入图的顶点数，边数");
//        vexNum = scanner.nextInt();
//        arcNum = scanner.nextInt();
//        vexs = new Object[vexNum];
//        System.out.println("分别输入图的各个顶点");
//        for (int v = 0; v < vexNum; v ++) {
//            vexs[v] = scanner.next();
//        }
//        arcs = new int[vexNum][vexNum];
//        for (int v = 0; v < vexNum; v ++) {
//            for (int u = 0; u < vexNum; u ++) {
//                arcs[v][u] = INFINITY;
//            }
//        }
//        System.out.println("请输入各个边的两个顶点以及权值");
//        for (int k = 0; k < arcNum; k ++) {
//            int v = locateVex(scanner.next());
//            int u = locateVex(scanner.next());
//            arcs[v][u] = scanner.nextInt();
//        }
//
//
//
//    }
//
//
//    //创建有向图
//    private void createDG () {
//
//    }
//
//    //创建无向网
//    private void createUDN () {
//
//    }
//
//    //创建有向网
//    private void createDN () {
//
//    }
//    //返回顶点数
//    private int getVexNum () {
//        return arcNum;
//    }
//    //给定顶点的值vex，返回其在图中的位置，如果图中不包含此顶点，则返回-1
//    public int locateVex(Object vex) {
//        for (int v = 0; v < vexNum; v ++) {
//            if (vexs[v].equals(vex)) {
//                return v;
//            }
//        }
//        return -1;
//    }
//
//    //寻找第一个邻接点的算法
//    public int firstAdjVex(int v) throws Exception{
//        if (v < 0 && v >= vexNum) {
//            throw new Exception("第" + v + "个点不存在");
//        }
//        for (int j = 0; j < vexNum; j ++) {
//            if (arcs[v][j] != 0 && arcs[v][j] < INFINITY) {
//                return j;
//            }
//        }
//        return -1;
//    }
//
//    //寻找下一个邻接点的算法
//
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    public static boolean[] visited;
//    public static void BFSTraverse(IGraph G) throws Exception {
//        visited = new boolean[G.getVexNum()];
//        for (int v = 0; v < G.getVexNum(); v ++) {
//            visited[v] = false;
//        }//初始化数组
//        for (int v = 0; v < G.getVexNum(); v ++) {
//            if (!visited[v]) {
//                BFS(G, v);
//            }
//        }
//    }
//    public static void BFS(IGraph G, int v) throws Exception {
//        visited[v] = true;
//        System.out.print(G.getVex(v).toString() + " ");
//        Queue Q = new LinkedList();
//        Q.offer(v);
//        while (!Q.isEmpty()) {
//            int u = (Integer) Q.poll();
//            for (int w = G.firstAdjVex(u); w >= 0; w = G.nextAdjVex(u, w)) {
//                if (!visited[w]) {
//                    visited[w] = true;
//                    System.out.print(G.getVex(w).toString() + " ");
//                }
//            }
//        }
//    }
//    public static void DFSTraverse(IGraph G) throws Exception {
//        visited = new boolean[G.getVexNum()];
//        for (int v = 0; v < G.getVexNum(); v ++) {
//            visited[v] = false;
//        }
//        for (int v = 0; v < G.getVexNum(); v ++) {
//            if (!visited[v]) {
//                DFS(G, v);
//            }
//        }
//    }
//    public static void DFS(IGraph G, int t) throws Exception {
//        visited[t] = true;
//        System.out.print(G.getVex(t).toString() + " ");
//        for (int w = G.firstAdjVex(t); w >= 0; w = G.nextAdjVex(t, w)) {
//            if (!visited[w]) {
//                DFS(G, w);
//            }
//        }
//    }
//}