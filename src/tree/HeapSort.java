package tree;

public class HeapSort {
    //判断heap堆中索引i处堆元素是否小于索引j处的元素
    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }
    //交换heap堆中i索引和j处索引的值
    private static void exch(Comparable[] heap, int i, int j){
        Comparable tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    //根据原数据source,构造出heap堆
    private static void creatHeap(Comparable[] source, Comparable[] heap){
        //把source中的元素拷贝到heap中，heap中到元素就形成一个无序的堆
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中堆元素做小城调整（从长度堆一半处开始调整，往索引1处扫描）
        for (int i = heap.length/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }
    }

    //对source数组中的元素从小到大排序
    public static  void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length+1];
        creatHeap(source,heap);
        int N = heap.length-1;
        while(N!=1){
            //交换元素
            exch(heap,1,N);
            //排序交换后最大元素所在的索引，让它不要参与下沉
            N--;
            //需要对索引1处的元素进行下沉调整
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,heap.length-1);
    }

    //在heap堆中，堆target处堆元素做下沉，氛围是0-range
    private static void sink(Comparable[] heap, int target, int range){
        while(2*target<=range){
            //找出当前结点的较大结点
            int max;
            if(2*target+1<=range){
                if(less(heap,2*target,2*target+1)){
                    max = 2*target+1;
                }else {
                    max = 2*target;
                }
            }else {
                max = 2*target;
            }
            //比较当前节点的值和较大结点的值
            if(!less(heap,target,max)){
                break;
            }
            exch(heap,target,max);
            target=max;
        }
    }
}
