public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
        left = null;
        right = null;
    }

    public void add(int nValue){
        if(nValue < value){
            if(left == null)
                left = new TreeNode(nValue);
            else
                left.add(nValue);
        }else{
            if(right == null)
                right = new TreeNode(nValue);
            else
                right.add(nValue);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        TreeNode other = (TreeNode) obj;

        if(left == null && other.left == null && right == null && other.right == null)
            return true;
        if(left == null && other.left == null && right != null && other.right != null)
            return true;
        if(left != null && other.left != null && right == null && other.right == null)
            return true;
        if(left != null && other.left != null && right != null && other.right != null)
            return true;
        return false;
    }
}
