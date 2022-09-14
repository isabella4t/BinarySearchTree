public class BinaryTree {
    Node root;

    public BinaryTree(){}
    public void insert(Node nee){
        if(nee==null) return;
        Node newParent = findInsertNode(nee.getKey());
        if(newParent == null) root = nee;
        else {
            nee.setParent(newParent);
            if(nee.getKey()>newParent.getKey()) newParent.setRchild(nee);
            else newParent.setLchild(nee);
        }
    }
    public Node findInsertNode(int key){
        Node ree = null;
        Node roo = root;
        while (roo!=null){
            ree = roo;
            if(key>roo.getKey()) roo = roo.getRchild();
            else roo = roo.getLchild();
        }

        //current issue, it only goes to the left
        return ree;
    }

    public boolean childless(Node t){
        return (t.getLchild()==null&&t.getRchild()==null);
    }
    public boolean onekid (Node t){
        return (t.getLchild()!=null&&t.getRchild()!=null&&childless(t)==false);
    }

    //makes parent into null
    public void scrubParent(Node a){
        if(a==null) return;
        Node p = a.getParent();
        if(p==null) root = null;
        else{
            if(a==p.getRchild()) p.setRchild(null);
            else p.setLchild(null);
        }
    }

    public void spliceOut(Node a){

    }

    public void delete(Node a){
        if (a.getParent() != null){
            a.getParent().setLchild(a.getLchild()); //moves the next one down
        }
        else{
             root = a.getLchild();
        }
        if(a.getLchild()!=null){
            a.getLchild().setParent(a.getParent());
        }
    }
/*
    public Node search(Node x, int key){
        while(x != null && x.getKey() !=key){
            if(key<x.getKey())  x = x.getLchild();
            else x = x.getRchild();
        }
        return x;
    public void insert(Node a){
        a.setLchild(root);
        if(root !=null){
            root.setParent(a);
        }
        root = a;
        a.setParent(null);

    }

 */
}
