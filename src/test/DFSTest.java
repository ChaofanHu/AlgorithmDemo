package test;

import graph.DepthFirstSearch;
import graph.Graph;

public class DFSTest {
    public static void main(String[] args) {

        //准备Graph对象
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(3,5);
        graph.adj(1);
        //准备深度优先搜索对象
        DepthFirstSearch dfs = new DepthFirstSearch(graph,1);
        System.out.println(dfs.count());
        System.out.println(dfs.marked(2));
    }
}
