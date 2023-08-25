package linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    private Node head;
    private Node last;
    private int N;

    public Queue(){
        this.head = new Node(null,null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }
    //入队
    public void enqueue(T t){
        if (last==null) {
            //当前尾节点last为null
            last = new Node(t,null);
            head.next = last;
        } else {
            //当前尾节点不为null
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next = last;
        }
        N++;
    }
    //出队
    public T dequeue(){
        if(isEmpty()==true){
            return null;
        }
        Node oldFirst = head.next;
        head.next=oldFirst.next;
        N--;
        //如果队列中的元素被删完了，需要重置last为null；
        if(isEmpty()==true){
            last=null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class QIterator implements Iterator{
        private Node n;

        public QIterator(){
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            return n.next.item;
        }
    }

    private class Node{
        public T item;
        public Node next;

        public Node(T t, Node next){
            this.item = t;
            this.next = next;
        }
    }
}
