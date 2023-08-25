package linear;

public class SequenceList <T>{
    private T[] eles;
    private int N;

    public SequenceList(int capacity){
        this.eles = (T[])new Object[capacity];
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //线性表的长度
    public int length(){
        return N;
    }

    //获取指定位置的元素
    public T get(int i){
        return eles[i];
    }

    //向线性表中添加元素t
    public void insert(T t){
        eles[N++] = t;
    }

    //在i元素处插入元素t
    public void insert(T t, int i){
        //把i元素往后的数据往后移一位
        for(int index = N-1;index >i; index-- ){
            eles[index] = eles[index-1];
        }
        //再把t元素放到i索引处即可
        eles[i] = t;
    }

    //删除指定位置i索引处的位置，并返回该元素
    public T remove(int i){
        //记录索引处的值
        T temp = eles[i];
        //索引i后面的元素依次往前移动一位
        for (int index = i; index<N-1; index++){
            eles[index] = eles[index+1];
        }
        //元素个数减一
        this.N--;
        return temp;
    }

    //查找指定元素的第一个索引
    public int indexOf(T t){
        for (int index = 0; index < N; index ++){
            if (eles[index].equals(t)){
                return index;
            }
        }
        return -1;
    }
}
