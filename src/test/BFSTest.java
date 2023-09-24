package test;

import graph.BreadthFirstSearch;
import graph.Graph;

public class BFSTest {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(4,5);
        graph.addEdge(3,2);

        BreadthFirstSearch bfs = new BreadthFirstSearch(graph,0);
        System.out.println(bfs.count());
        System.out.println(bfs.marked(1));
    }
}
