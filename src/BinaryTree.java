public class BinaryTree {
    Node root;

    public BinaryTree(){}
    public void insert(Node nee){
        Node newParent = findInsertNode(nee.getKey());
        if(newParent == null) root = nee;
        else {
            if(nee.getKey()>newParent.getKey()) newParent.setRchild(nee);
            else newParent.setLchild(nee);
        }
    }
    public Node findInsertNode(int key){
        Node ree = null;
        Node roo = root;
        while (roo!=null){
            ree = roo;
            if(key>roo.getKey()) roo = roo.getLchild();
            else roo = roo.getLchild();
        }
        return ree;
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
