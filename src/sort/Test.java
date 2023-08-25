package sort;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] a = {9,8,7,6,5,4,3,2,1};
//        SelectionSort.sort(a);
//        InsertionSort.sort(a);
//        ShellSort.sort(a);
//        MergeSort.sort(a);
        QuickSort.sort(a);


        System.out.println(Arrays.toString(a));


    }
}
