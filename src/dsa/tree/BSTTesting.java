package dsa.tree;

public class BSTTesting {
    
    static class BinaryTreeNode {
        private int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBST(BinaryTreeNode node) {
        if(node == null) {
            return true;
        }
        return isBSTInternal(node).isBst;
    }

    private MinMaxValue isBSTInternal(BinaryTreeNode node) {
        if(node != null) {
            MinMaxValue left = isBSTInternal(node.left);
            MinMaxValue right = isBSTInternal(node.right);
            
            if(left == null && right == null) {
                return new MinMaxValue(node.val, node.val, true,node);
            } else if(right == null) {
                return new MinMaxValue(left.minValue, node.val, left.isBst && node.val >= left.maxValue, node);
            } else if(left == null) {
                return new MinMaxValue(node.val, right.maxValue, right.isBst && node.val <= right.minValue, node);
            } else {
                boolean isBst = left.isBst && right.isBst && node.val >= left.maxValue && node.val <= right.minValue;
                return new MinMaxValue(left.minValue, right.maxValue, isBst, node);
            }
        }
        return null;
    }




    static class MinMaxValue {
        int minValue;
        int maxValue;
        boolean isBst;
        BinaryTreeNode node;

        public MinMaxValue(int min, int max, boolean bst, BinaryTreeNode node) {
            this.minValue = min;
            this.maxValue = max;
            this.isBst = bst;
            this.node = node;
        }

    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(5);

        binaryTreeNode.left = new BinaryTreeNode(2);
        binaryTreeNode.left.left = new BinaryTreeNode(1);
        binaryTreeNode.left.right = new BinaryTreeNode(3);
        
        binaryTreeNode.right = new BinaryTreeNode(10);
        
        BSTTesting bstTesting = new BSTTesting();
        System.out.println(bstTesting.isBST(binaryTreeNode));
    }

}