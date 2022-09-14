public class Node {
    private Node parent;
    private Node lchild;
    private Node rchild;
    private int key;

    public Node(int _key){
        key = _key;
    }

    public void setKey(int key_){key = key_;}
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
        while(x.getLchild() != null){
            x = x.getLchild();
        }
        return x;
    }

    public Node successor(){ //if no right children, find parent that is also a left child
        Node ret = this;
        if(ret.getRchild()!=null) return ret.getRchild().minimum();

        Node up = ret.getParent();
      //  if(up!=null&&ret==up.getLchild()) return up;
        while(up !=null && ret == up.getRchild()){
            ret = up;
            up = ret.getParent();
        }
        return up;
    }

    public void printWalk(){
        if(lchild!=null) lchild.printWalk();
        System.out.println(" "+key);
        if(rchild!=null) rchild.printWalk();
    }
    public int kidcount(){
        int ret =0;
        if(lchild!=null)ret++;
        if(rchild!=null)ret++;
        return ret;
    }

}
