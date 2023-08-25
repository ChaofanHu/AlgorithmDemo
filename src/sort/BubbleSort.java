package sort;

public class BubbleSort {
    public static void bubbleSort(Comparable[] a){
        for(int i = a.length-1; i>0; i--){
            for (int j=0; j<i; j++){
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }
    private static boolean greater(Comparable v, Comparable m){
        return v.compareTo(m) > 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
