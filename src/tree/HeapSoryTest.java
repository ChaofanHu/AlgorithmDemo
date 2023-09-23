package tree;

public class HeapSoryTest {
    public static void main(String[] args) {
        String[] str = {"S","O","R","T","E","X","A","M","P","L","E"};
        HeapSort.sort(str);
        for(String i : str){
            System.out.println(i);
        }
    }
}
