package graph;

import linear.Queue;

public class Graph {
    //记录顶点数量
    private final int v;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int v){
        this.v = v;
        this.E=0;
        //初始化邻接表
        this.adj=new Queue[v];
        for (int i =0; i < adj.length; i++){
            adj[i] = new Queue<>();
        }
    }
    //获取图中顶点的数量
    public int V(){
        return this.v;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向图中添加一条边
    public void addEdge(int v, int w){
        //在无向图中国，边是没有方向的，索引该边既可以硕士从v到w到边，又可以是w到v到边，因此需要让w出现在v到邻接表中，v也需要出现在w到邻接表中
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        //边的数量加一
        E++;
    }
    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

}
