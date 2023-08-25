package sort;

public class SelectionSort {
    public static void sort(Comparable[] a){
        for(int i=0; i< a.length-2; i++){
            //define a var, record the min element index
            int minIndex = i;
            for(int j=i+1;j< a.length;j++){
                if(greater(a[minIndex], a[j])){
                    minIndex = j;
                }
            }
            //exchange
            exch(a,i,minIndex);
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
