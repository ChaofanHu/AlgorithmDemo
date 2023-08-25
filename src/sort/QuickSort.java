package sort;

public class QuickSort {
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length -1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo){
            return;
        }
        //对数组中lo索引到hi索引处到元素进行分组（左子组和右子组）
        int partition = partition(a, lo, hi);
        //让左子组有序
        sort(a,lo,partition);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    public static int partition(Comparable[] a, int lo, int hi){
        //找到基准值
        Comparable key = a[lo];
        //定义两个指针，分别只想待切分元素的最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi+1;
        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比基准值小的数值，停止
            while(less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //从左往右扫描，移动left指针，找到一个比基准值大的数值
            while(less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //判断left>=right，如果是，break，如果不是，交换元素
            if (left>=right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //交换基准值
        exch(a,lo,right);
        return right;
    }

    private static boolean less(Comparable v, Comparable m){
        boolean b = v.compareTo(m) < 0;
        return b;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable tep;
        tep = a[i];
        a[i] = a[j];
        a[j] = tep;
    }
}
