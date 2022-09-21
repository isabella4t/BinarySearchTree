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
    //helper
    public boolean childless(Node t){
        return (t.getLchild()==null&&t.getRchild()==null);
    }
    //helper
    public boolean onekid (Node t){
        return ((t.getLchild()!=null||t.getRchild()!=null)&&!childless(t));
    }
    public Node getRoot(){return root;}
    //scrubs nodes with no children
    public void scrubParent(Node a){
        if(a==null) return;
        Node p = a.getParent();
        if(p==null) root = null;
        else{
            if(a==p.getRchild()) p.setRchild(null);
            else p.setLchild(null);
        }
    }
    //for nodes with less than 2 children
    public void spliceOut(Node a){
        Node kid = a.getRchild();
        Node par = a.getParent();
        if(kid==null) kid = a.getLchild();

        if(kid !=null) kid.setParent(par);

        if(par ==null) root = kid;
        else{
            if(a==par.getRchild())par.setRchild(kid);
            else par.setLchild(kid);
        }
    }
    //for nodes with 2 children
    public void rotateOut(Node a){
        if (a==null) return;
        Node suc = a.successor();
        spliceOut(suc);
        a.setKey(suc.getKey());
    }
    // all 3 delete methods
    public void delete(Node a){
      // System.out.println("Deleting: " + a);
       if(childless(a)){
           scrubParent(a);
           return;
       }
       if(onekid(a))spliceOut(a);
       else rotateOut(a);
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
