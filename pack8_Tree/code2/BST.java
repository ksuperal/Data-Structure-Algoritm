//Kanokjan Singhsuwan 65011320
package pack8_Tree.code2;

public class BST {

    TreeNode root;

    public BST() {
        root = null;
    }

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null)
            return null;
        if (d == n.data)
            return n;
        if (d < n.data)
            return searchRecurse(d, n.left);
        return searchRecurse(d, n.right);
    }

    public TreeNode searchIter(int key) {
        if (root.data == key)
            return root;
        TreeNode current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left != null)
                    current = current.left;
            } else {
                if (current.right != null)
                    current = current.right;
            }
            if (current.data == key)
                return current;
            else
                current = null;
        }
        return null;
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null)
                        cur = cur.left;
                    else {
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else {
                    if (cur.right != null)
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            }
        }
    }

    public TreeNode findMaxFrom(TreeNode subtreeHead) {
        TreeNode current = subtreeHead;
        while (current != null && current.right != null)
            current = current.right;
        return current;
    }

    public void delete(int d, TreeNode current) {
        if (current == null)
            return; // not found
        if (d < current.data)
            delete(d, current.left);
        else if (d > current.data)
            delete(d, current.right);
        else { // found ... time to delete
            if (current.left == null && current.right == null) { // 0 child
                if (current.parent.left == current)
                    current.parent.left = null;
                else
                    current.parent.right = null;
            } else if (current.left == null || current.right == null) { // 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                q.parent = current.parent;
                if (current.parent.left == current)
                    current.parent.left = q;
                else
                    current.parent.right = q;
            } else { // two children
                TreeNode successor = findMaxFrom(current.left);
                current.data = successor.data;
                delete(successor.data, current.left);
            }
        }
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
    }

    public void printPreOrderRecurse(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.data + " ");
        printPreOrderRecurse(node.left);
        printPreOrderRecurse(node.right);
    }

    public void printInOrder() {
        printInOrderRecurse(root);
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node == null)
            return;
        printInOrderRecurse(node.left);
        System.out.println(node.data + " ");
        printInOrderRecurse(node.right);
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
    }

    private void printPostOrderRecurse(TreeNode node) {
        if (node == null)
            return;
        printPostOrderRecurse(node.left);
        printPostOrderRecurse(node.right);
        System.out.println(node.data + " ");

    }
}