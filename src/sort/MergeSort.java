package sort;

public class MergeSort {
    private static Comparable[] assist;

    public static void sort(Comparable[] a){
        //初始化辅助数组
        assist = new Comparable[a.length];
        //定义lo变量和hi变量，分别记录数组中最小到索引和最大到索引
        int lo=0;
        int hi=a.length-1;
        //调用sort重载方法完成数组a中从索引lo到hi到元素排序
        sort(a,lo,hi);
    }

    //对数组a中从lo到hi到元素进行排序
    private static void sort(Comparable[] a, int lo, int hi){
        //安全校验
        if(hi<=lo){
            return;
        }
        //对lo到hi之间到数据进行分组
        int mid = lo + (hi-lo)/2;
        //分别对每一组对数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        //再把两个组的数据进行归并
        merge(a,lo,mid,hi);
    }

    //合并
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid +1;
        //遍历，移动p1指针和p2指针，比较对应索引处的值，放到辅助索引处对应的索引
        while(p1<=mid && p2<=hi){
            if(less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++] = a[p2++];
            }
        }
        //遍历，如果p1的指针没有走完，那么顺序移动p1的指针，把对应的元素放到辅数组
        while(p1<=mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组
        while(p2<=mid){
            assist[i++] = a[p2++];
        }
        //把辅助数组的元素copy到原数组
        for (int j = lo; j <= hi; j++){
            a[j] = assist[j];
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
