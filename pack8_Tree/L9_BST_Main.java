package pack8_Tree;

import java.util.ArrayList;
import java.util.Arrays;

import pack8_Tree.code2.BST;

public class L9_BST_Main {
    public static void main(String[] args) {
        // demo1();
        q2();
    }

    public static void demo1() {
        System.out.println("---Demo1---- ");
        int[] data = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
        BST bst = new BST();
        for (int j = 0; j < data.length; j++)
            bst.insert(data[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());

        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.printInOrder();

        System.out.println("---Demo2---- ");
        System.out.println("Tree height = " + bst.height());
        System.out.println("node with max value " + bst.findMaxFrom(bst.getRoot()));

        System.out.println("---Demo3--- ");
        int[] dat2 = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        bst = new BST();
        for (int j = 0; j < dat2.length; j++)
            bst.insert(dat2[j]);

        bst.delete(12, bst.getRoot());

        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(16)); // null<-16->null
        System.out.println(bst.search(10)); // 8<-10->null
        System.out.println(bst.search(12)); // not found
    }

    // Rest of the code remains unchanged...

    // public static void demo2() {
    // println("node with max value " +
    // bst.findMaxFrom(bst.getRoot()));
    // }
    public static void deemo1() {
        System.out.println("-insert and preOrder traversal-");
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };

        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);

        bst.printPreOrder();
        // 15 10 8 12 20 18 16 19 25 30
        System.out.println();
        deemo2(bst);
    }

    static void deemo2(BST bst) {
        System.out.println("-more traversal---");
        bst.printInOrder();
        System.out.println();
        // 8 10 12 15 16 18 19 20 25 30
        bst.printPostOrder();
        System.out.println();
        // 8 12 10 16 19 18 30 25 20 15
        demo3(bst);
    }

    static void demo3(BST bst) {
        System.out.println("-search recursive---");
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null
        System.out.println(bst.search(1)); // null
        System.out.println(bst.searchRecurse(10, bst.getRoot()));
        // if searchRecurse and getRoot is available
        System.out.println("-search iterative---");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));

    }

    static void q2() {
        // A B C D E
        int[][] thisGraph = {
                { 0, 3, 0, 0, 2 }, // your 1.1
                { 3, 0, 1, 0, 0 },
                { 0, 1, 0, 4, 0 },
                { 0, 0, 4, 0, 5 },
                { 2, 0, 0, 5, 0 } };
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }

    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.add(0); // root is at A, we'll suffix next city
        while (notEmpty(stack)) {
            int parent = stack.remove(stack.size() - 1);
            visited.add(parent);
            for (int x = 0; x < thisGraph.length; x++) {
                if (0 < thisGraph[parent][x]
                        && thisGraph[parent][x] < Integer.MAX_VALUE && !visited.contains(x)) {
                    stack.add(parent);
                    stack.add(x);
                    /* your code 1b */
                    System.out.println("Edge " + parent + ", " + x);
                }
            } // for
        }
    }

    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }
}
