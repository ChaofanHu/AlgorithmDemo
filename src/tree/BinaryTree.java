package tree;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    private Node root;
    //the number if the nodes
    private int n;
    private class Node{
        private Node left;
        private Node right;
        private Key key;
        private Value value;

        public Node(Node left, Node right, Key key, Value value) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return n;
    }
    //add key-value pair to tree
    public void put(Key key, Value value){
        this.root = put(root, key, value);
    }

    //add key-value pair in tree x, and return the new tree
    private Node put(Node n, Key key, Value value){
        //if x's sub node is null
        if(n==null){
            this.n++;
            return new Node(null,null,key,value);
        }
        //x's xub node is not null
        //compare node x's key and value
        int cmp = key.compareTo(n.key);
        //if key smaller than x'key
        if(cmp > 0){
            n.right = put(n.right, key, value);
        } else if (cmp < 0 ) {
            //if lager
            n.left = put(n.left, key, value);
        }else {
            //equals
            n.value = value;
        }
        return n;
    }
    //查找key对应的value
    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x, Key key){
        if(x==null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        //if key smaller than x'key
        if(cmp > 0){
            return get(x.right,key);
        } else if (cmp < 0 ) {
            return get(x.left,key);
        }else {
            return x.value;
        }
    }

    //删除key对应的节点
    public void delete(Key key){
        delete(root,key);
    }

    public Node delete(Node x, Key key){
        //如果为null
        if(root==null){
            return null;
        }

        //xw不为null
        int cmp = key.compareTo(x.key);
        //if key smaller than x'key
        if(cmp > 0){
            x.right = delete(x.right,key);
        } else if (cmp < 0 ) {
            x.left = delete(x.left,key);
        }else {
            this.n--;
            if(x.right==null){

                return x.left;
            }
            if(x.right==null){
                return x.left;
            }

            Node minNode = x.right;
            while (minNode.left!=null){
                minNode = minNode.left;
            }
            //删除右子树的最小节点
            Node n = x.right;
            while(n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }else {
                    n = n.left;
                }
            }

            minNode.left = x.left;
            minNode.right = x.right;
            x=minNode;
        }
        return null;

    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }

    }


}
