package graph;

public class DepthFirstPaths {
    //索引达标顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上最后一个顶点
    private int[] edgeTo;
}
