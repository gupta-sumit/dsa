package algo.Tree;


import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int val) {
        TreeNode treeNode = new TreeNode(val);
        if(root == null) {
            root = treeNode;
        } else {
            TreeNode parent = null;
            TreeNode node = root;
            while(node != null) {
                if(val < node.val) {
                    parent = node;
                    node = node.left;
                } else {
                    parent = node;
                    node = node.right;
                }
            }
            if(parent != null) {
                 if(val < parent.val) {
                     parent.left = treeNode;
                 } else {
                     parent.right = treeNode;
                 }
                treeNode.parent = parent;
            }
        }
    }

    private TreeNode search(int key, TreeNode node) {
        if(node != null ) {
            if(node.val == key) {
                return node;
            }
            if(key < node.val) {
                return search(key, node.left);
            } else {
                return search(key, node.right);
            }
        }
        return null;
    }


//    public TreeNode lca(int key1, int key2) {
//
//    }
//
    public void delete(int  key) {
        TreeNode node = search(key, root);
        if(null == node) {
           return;
        }
        // Case 1 : Node does not have any children
        if(node.left == null && node.right == null) {
            deleteLeafNode(node);
        } else if(node.left != null && node.right != null) {
            boolean changeRoot = false;
            if(root == node) {
                changeRoot = true;
            }
            TreeNode successor = findSuccessor(node);
            if(successor == node.right) {
                TreeNode parent = node.parent;
                successor.left = node.left;
                if(null == parent) {
                    successor.parent = null;
                } else {
                    if(parent.left == node) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                    successor.parent = parent;
                }
            } else {
                if(isLeafNode(successor)) {
                    deleteLeafNode(successor);
                } else {
                    successor.parent.left = successor.right;
                    successor.right.parent = successor.parent;
                }
                successor.left = node.left;
                if(node.left != null) {
                    node.left.parent = successor;
                }
                successor.right = node.right;
                if(node.right != null) {
                    node.right.parent = successor;
                }
                TreeNode parent = node.parent;
                if(node.parent != null) {
                    if(parent.left == node) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                } else {
                    successor.parent = null;
                }
            }

            if(changeRoot) {
                root = successor;
            }
        } else {
            deleteSingleChildNode(node);
        }

    }

    private void deleteSingleChildNode(TreeNode node) {
        if(node.left == null && node.right != null){
            // Left child is null;
            if(root == node) {
                root = node.right;
            } else {
                TreeNode parent = node.parent;
                if(parent.left == node) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }

        } else if(node.left != null && node.right == null) {
            if(root == node) {
                root = node.left;
            } else {
                TreeNode parent = node.parent;
                if(parent.left == node) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
            }
        }
    }

    private void deleteLeafNode(TreeNode node) {
        if(root == node) {
            root = null;
        } else {
            TreeNode parent = node.parent;
            if(parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    public TreeNode findSuccessor(TreeNode node) {
        if(node.right != null) {
            return minimum(node.right);
        }
        TreeNode parent = node.parent;
        while(parent != null && parent.right == node) {
            parent = parent.parent;
            node = parent;
        }
        return parent;
    }

    public TreeNode minimum(TreeNode node) {
        TreeNode curr = node;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private boolean isLeftChild(TreeNode node) {
        return node.parent.left == node;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void inorder(Consumer<BinarySearchTree.TreeNode> nodeConsumer) {
        inorderInternal(root, nodeConsumer);
    }

    public List<Integer>  levelOrder() {
        if(root != null) {
            List<Integer> treeNodes = new ArrayList<>();
            LinkedList<TreeNode>   queue = new LinkedList<>();
            queue.add(root);
            treeNodes.add(root.val);
            LinkedList<Integer> indexes = new LinkedList<>();
            indexes.add(0);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    treeNodes.add(node.left.val);
                    queue.add(node.left);
                } else {
                    treeNodes.add(null);
                }
                if(node.right != null) {
                    treeNodes.add(node.right.val);
                    queue.add(node.right);
                } else {
                    treeNodes.add(null);
                }
            }

            return treeNodes;
        }

        return Collections.emptyList();
    }

    private void inorderInternal(BinarySearchTree.TreeNode node,Consumer<BinarySearchTree.TreeNode> nodeConsumer) {
        if(node != null) {
            inorderInternal(node.left,nodeConsumer);
            nodeConsumer.accept(node);
            inorderInternal(node.right,nodeConsumer);
        }
    }


    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;


        public TreeNode(int val) {
            this.val = val;
        }
    }
}
