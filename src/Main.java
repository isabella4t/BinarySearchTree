import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    static int pass = 0;
    static int fail = 0;

    public static void main(String[] args){

        testConstructor();
        testSet();
        testInsertNode();
        testInsert();
        testMinimum1();
        testSuccessor1();
        testSuccessor2();
        testScrubParent();
        testSpliceOut1();
        testSpliceOut2();
        testRotate1();
        testDelete1();
        testDelete2();
        testDelete3();

        System.out.print("passes: " + pass + " fails: " + fail);
    }

    public static void testConstructor(){
        Node four = new Node(4);
        BinaryTree fl = new BinaryTree();
        if(fl.root==null)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"constructor failed, not an empty root");
        }
        fl.root = four;
        if (fl.root == four) pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"constructor failed, value not assigned");
        }
        if(fl.root.getParent()==null)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"constructor failed, root's parent wasn't null");
        }
    }
    public static void testSet(){
        Node four = new Node(4);
        BinaryTree fl = new BinaryTree();
        fl.root = four;
        Node two = new Node(2);
        four.setLchild(two);
        Node got = four.getLchild();
        if(got==two) pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSet, expected " + two.getKey() + ", got " + got.getKey());
        }
        Node six = new Node(6);
        four.setRchild(six);

        got = four.getRchild();
        if(got==six) pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSet, expected " + six.getKey() + ", got " + got.getKey());
        }


    }
    public static void testInsertNode(){
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);

        BinaryTree tree = new BinaryTree();
        tree.root = two;

       two.setRchild(three);
       two.setLchild(one);

        Node got = tree.findInsertNode(1);
        if(got == one) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING,"failed findInsertionNode, expected "+ one.getKey()+ ", got " + got.getKey());

        }
        got = tree.findInsertNode(8);
        if(got == three) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING,"failed findInsertionNode, expected  "+ three.getKey()+", got " + got.getKey());

        }

    }
    public static void testInsert(){
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
        Node four = new Node(6);
        Node five = new Node(7);
        Node six = new Node(12);

        Node n = new Node(8);
        Node m = new Node(13);
        Node l = new Node(1);
        Node w = new Node(3);

        BinaryTree tree = new BinaryTree();
        tree.root = four;

        four.setLchild(three);
        four.setRchild(five);
        three.setLchild(two);
        two.setLchild(one);
        five.setRchild(six);
        tree.insert(n);

        if(six.getLchild()==n)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed insert, didn't get set 8 as left child of node 6");
        }
        tree.insert(m);
        if(six.getRchild()==m)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed insert, didn't get 13 it as right child of node 6");
        }

        tree.insert(l);
        if(one.getLchild()==l)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed insert, didn't get set 1 as left child of node 1");
        }
        tree.insert(w);
        if(one.getRchild()==w)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed insert, didn't get set 3 as right child of node 1");
        }
    }
    public static void testMinimum1(){
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);

        BinaryTree tree = new BinaryTree();
        tree.root = three;

        tree.insert(one);
        tree.insert(two);
        tree.insert(three);

        if(tree.root.minimum()==one)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed minimum");
        }

    }
    public static void testSuccessor1(){
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(3);
        Node four = new Node(3);
        Node five = new Node (4);

        BinaryTree tree = new BinaryTree();

        tree.insert(one);
        tree.insert(two);
        tree.insert(three);
        tree.insert(four);
        tree.insert(five);

        Node suc = one.successor();
        if(suc == four)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key 3, got key" + suc.getKey());
        }
        suc = four.successor();
        if(suc == three)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key 3, got key" + suc.getKey());
        }
        suc = five.successor();
        if(suc == null)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key null, got key" + suc.getKey());
        }
    }
    public static void testSuccessor2(){
        Node a = new Node(4);
        BinaryTree tree = new BinaryTree();
        tree.root = a;

        Node b = new Node(1);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e =  new Node(3);
        Node f =  new Node(3);
        Node g = new Node(4);
        Node h = new Node(5);
        Node i =  new Node(6);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        tree.insert(e);
        tree.insert(f);
        tree.insert(g);
        tree.insert(h);
        tree.insert(i);

        Node suce = e.successor();
        if(suce == g)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key 4, got key " + suce.getKey());
        }

        Node sucf = f.successor();
        if(sucf == e)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key 3, got key" + sucf.getKey());
        }

        Node sucg = g.successor();
        if(sucg == tree.root)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed successor, expected key 4, got key" + sucg.getKey());
        }
    }
    public static void testScrubParent(){
        Node a = new Node(1);
        BinaryTree tree = new BinaryTree();
        tree.root = a;
        Node b = new Node(9);
        Node c = new Node(7);
        tree.insert(b);
        tree.insert(c);

        tree.scrubParent(c);
        if(b.getLchild()==null)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testScrubParent, b.getLchild = " + b.getLchild());
        }

        tree.scrubParent(b);
        if(a.getRchild()==null)pass++;
         else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testScrubParent, b.getRchild = " + a.getRchild());
        }
    }
    public static void testSpliceOut1(){
        Node a = new Node(1);
        BinaryTree tree = new BinaryTree();
        tree.root = a;
        Node b = new Node(9);
        Node c = new Node(14);
        Node d = new Node(13);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        tree.spliceOut(c);
        if(b.getRchild()==d)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSpliceout, b.getRchild = " + b.getRchild());
        }
        tree.spliceOut(b);
        if(tree.root.getRchild()==d)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSpliceout, tree.root.getRchild = " + tree.root.getRchild());
        }
    }
    public static void testSpliceOut2(){
        Node a = new Node(14);
        BinaryTree tree = new BinaryTree();
        tree.root = a;
        Node b = new Node(13);
        Node c = new Node(1);
        Node d = new Node(9);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        tree.spliceOut(c);
        if(b.getLchild()==d&&d.getParent()==b)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSpliceout2, b.getLchild = " + b.getLchild());
        }
        tree.spliceOut(b);
        if(tree.root.getLchild()==d&&d.getParent()==tree.root)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed testSpliceout2, tree.root.getLchild = " + tree.root.getLchild());
        }
    }
    public static void testRotate1() {
        Node a = new Node(9);
        BinaryTree tree = new BinaryTree();
        tree.root = a;
        Node b = new Node(7);
        Node c = new Node(14);
        Node d = new Node(12);
        Node e = new Node(16);
        Node f = new Node(13);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        tree.insert(e);
        tree.insert(f);

        tree.rotateOut(c);
        if (tree.root.getRchild().getKey() == 16 && c.getLchild()==d) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "failed testRotate1, tree.root.getRchild() = " + tree.root.getRchild().getKey());
        }
        tree.rotateOut(tree.root);
        if (tree.root.getKey() == 12 && c.getLchild().getKey()==13) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "failed testRotate1, tree.root = " + tree.root.getKey());
        }

    }
    public static void testDelete1() {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        Node b = new Node(3);
        Node c = new Node(4);
        tree.insert(b);
        tree.insert(c);
        tree.delete(c);
        if(b.getRchild()==null)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING, "failed testdelete, scrub");
        }
    }
    public static void testDelete2(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        Node b = new Node(9);
        Node c = new Node(14);
        Node d = new Node(13);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);

        tree.delete(c);
        if(b.getRchild().getKey()==13)pass++;
        else{
            fail++;
            LOGGER.log(Level.WARNING,"failed test delete, splice");
        }
    }
    public static void testDelete3() {
        Node a = new Node(9);
        BinaryTree tree = new BinaryTree();
        tree.root = a;
        Node b = new Node(7);
        Node c = new Node(14);
        Node d = new Node(12);
        Node e = new Node(16);
        Node f = new Node(13);

        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        tree.insert(e);
        tree.insert(f);

        tree.delete(c);
        if (tree.root.getRchild().getKey() == 16 && c.getLchild()==d) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "failed testRotate1, tree.root.getRchild() = " + tree.root.getRchild().getKey());
        }
    }
}
