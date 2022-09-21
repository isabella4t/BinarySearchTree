import static java.lang.Math.sqrt;
public class Node {
    private Node parent;
    private Node lchild;
    private Node rchild;
    private int key;
    //constructor
    public Node(int _key){
        key = _key;
    }

    public void setKey(int key_){key = key_;}
    public int getKey(){
        return key;
    }

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

    //finds next biggest
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
    //prints the tree
    public void printWalk(){
        if(lchild!=null) lchild.printWalk();
        System.out.println(" "+key);
        if(rchild!=null) rchild.printWalk();
    }

    //returns string with the tree
    public String stringWalk(){
        String ree = "";
        if(lchild!=null) lchild.stringWalk();
        ree = " "+ key + "\n";
        if(rchild!=null) rchild.stringWalk();
        return ree;
    }
    public int kidcount(){
        int ret =0;
        if(lchild!=null)ret++;
        if(rchild!=null)ret++;
        return ret;
    }

    public int depth(){
        if(lchild ==null && rchild==null) return 0;
        else{
            if(lchild==null) return rchild.depth()+1;
            if(rchild==null) return lchild.depth()+1;
            //math.max(rchild.depth(),lchild.depth())+1;
            return 1;
        }
    }

}
