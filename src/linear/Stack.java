package linear;


import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node head;
    private int N;

    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(T t){
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        //创建新节点
        Node newNode = new Node(t, null);
        //让首节点指向新节点
        head.next = newNode;
        //让新节点指向原来的第一个节点
        newNode.next = oldFirst;
        //元素个数+1
         N++;
    }

    public T pop(){
        //找到首节点指向的第一个节点
        Node oldFirst = head.next;
        //让首节点指向原来第一个节点的下一个
        head.next=oldFirst.next;
        //元素个数-1
        N--;
        return oldFirst.item;
    }



    private  class Node{
        public T item;
        public Node next;

        public Node(T t, Node next){
            this.item = t;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            return n.next.item;
        }
    }
}
