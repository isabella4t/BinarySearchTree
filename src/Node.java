public class Node {
    private Node parent;
    private Node lchild;
    private Node rchild;
    private int key;

    public Node(int _key){
        key = _key;
    }
    public int getKey(){
        return key;
    }
    /*
    public void insert(Element _next) {
        if(next == null) next = _next;
        next.insert(_next);
    }
    */

    public void setParent(Node par){
        parent = par;
    }
    public void setLchild(Node left){
        lchild = left;
    }
    public void setRchild(Node right){
        rchild = right;
    }


    public Node getParent(){
        return parent;
    }

    public Node getLchild(){
        return lchild;
    }
    public Node getRchild(){
        return rchild;
    }

    public Node minimum(){
        Node x = this;
        while(getLchild() != null){
            x = x.getLchild();
        }
        return x;
    }

    public Node successor(){
        if(getRchild()!=null) return getRchild();

        Node x = getParent();
        while(x!=null&&this.getKey()>x.getKey()){
            x = x.getParent();
        }
        return x;

    }
}
