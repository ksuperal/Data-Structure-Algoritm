package pack8_Tree.code2;

public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (left != null) {
            sb.append(left.data).append("<-");
        } else {
            sb.append("null<-");
        }

        sb.append(data);

        if (right != null) {
            sb.append("->").append(right.data);
        } else {
            sb.append("->null");
        }

        return sb.toString();
    }
}
