package graph;

import linear.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        this.count=0;
        this.waitSearch = new Queue();
        marked[s] = true;
        bfs(G,s);
    }

    private void bfs(Graph G, int v){
        waitSearch.enqueue(v);
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            for (Integer w: G.adj(wait)){
                if (!marked[w]) {
                    marked[w]=true;
                    waitSearch.enqueue(w);
                    count++;
                    bfs(G,v);
                }

            }
        }

    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return this.count;
    }
}
