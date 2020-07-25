package algo.Tree;

import algo.utils.ConsolePrinter;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(100);
        bst.insert(50);
        bst.insert(150);
        bst.insert(120);
        bst.insert(200);
        bst.insert(170);
        bst.insert(175);
        bst.insert(70);
        bst.insert(20);

        ConsolePrinter.out(bst.levelOrder());

        System.out.println();
        System.out.println("Deleting....");
        bst.delete(100);
        ConsolePrinter.out(bst.levelOrder());
        bst.delete(150);
        ConsolePrinter.out(bst.levelOrder());
        bst.delete(50);
        //bst.delete(100);

        ConsolePrinter.out(bst.levelOrder());

//        bst.delete(100);
//
//        bst.inorder((t) -> {
//            BinarySearchTree.TreeNode t1 = t;
//            System.out.print(t1.val + " ");
//        });
    }
}
