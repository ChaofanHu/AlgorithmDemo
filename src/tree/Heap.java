package tree;

public class Heap<T extends Comparable<T>> {
    //存储堆中堆元素
    private  T[] items;
    //the number  of elements
    private int N;

    public Heap(int capacity){
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //判断堆中索引i处堆元素是否小于索引j出的元素
    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    //交换j与i出的值
    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;

    }

    //insert a value
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    //使用上浮算法，使用索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环比较父结点的值
        while(k>1){
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k = k/2;
        }
    }

    public T delMax(){
        T max = items[1];

        //交换索引1处与最大索引处的值
        exch(1,N);
        //删除最大索引处的值
        items[N] = null;
        //元素个数-1
        this.N--;
        //通过下沉算法让堆重新有序
        sink(1);
        return  max;
    }

    //使用下沉算法，使索引k处堆元素能在堆中处于一个正确的位置
    private void sink(int k){
        //对比2k与2k+1较大处处的结点的值；
        while (2*k<N){
            int max;
            //如果有右结点
            if(2*k +1 <= N){
                if (less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else {
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }
            //比较当前结点的值
            if(less(k,max)){
                exch(k,max);
                k=max;
            }else {
                break;
            }
        }
    }
}
