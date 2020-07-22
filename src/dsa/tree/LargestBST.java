package dsa.tree;

public class LargestBST {

    int maxSize = 0;
    TreeNode largestBSTRoot;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }


    }

    public TreeNode largestBST(TreeNode node) {
        if(null == node) {
            return null;
        }
        largestBSTInternal(node);
        return largestBSTRoot;
    }

    private NodeWrapper largestBSTInternal(TreeNode node) {
        if(node != null) {
            NodeWrapper left = largestBSTInternal(node.left);
            NodeWrapper right = largestBSTInternal(node.right);

            if(left == null && right == null) {
                // leaf node
                if(1 > maxSize) {
                    maxSize = 1;
                    largestBSTRoot = node;
                }
                return new NodeWrapper(node.val, node.val, 1, true);
            } else if(left == null) {
                boolean isBST =  right.isBST && node.val < right.min;

                int size = right.size + 1;
                if(isBST && size > maxSize) {
                    maxSize = size;
                    largestBSTRoot = node;
                }
                return new NodeWrapper(node.val, right.max, 1 + right.size, right.isBST && node.val < right.min);
            } else if(right == null) {
                boolean isBST = left.isBST && node.val > left.max;
                int size = left.size  + 1;
                if(isBST && size > maxSize) {
                    maxSize = size;
                    largestBSTRoot = node;
                }
                return new NodeWrapper(left.min, node.val, 1 + left.size, isBST);
            } else {
                
                boolean isBST = left.isBST && right.isBST && node.val > left.max && node.val < right.min;
                int size = left.size + right.size + 1;
                if(isBST && size > maxSize) {
                    maxSize = size;
                    largestBSTRoot = node;
                }
                return new NodeWrapper(left.min,right.max, size, isBST);
            }

        }
        return null;
    }

    
    static class NodeWrapper {
        int min;
        int max;
        int size;
        boolean isBST;

        NodeWrapper(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        LargestBST largestBST = new LargestBST();
        

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(12);

        root.right = new TreeNode(25);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(30);

        TreeNode node = largestBST.largestBST(root);
        System.out.println(node.val);
    }
    
}